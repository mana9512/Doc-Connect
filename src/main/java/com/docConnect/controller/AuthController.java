package com.docConnect.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.docConnect.dao.DoctorDAO;
import com.docConnect.dao.PatientDAO;
import com.docConnect.pojo.Doctor;
import com.docConnect.pojo.Patient;
import com.docConnect.pojo.UserRole;
import com.docConnect.validators.DoctorValidator;
import com.docConnect.validators.UserRoleValidator;

@RestController
public class AuthController {
	@Autowired
	DoctorValidator docValidator;

	@Autowired
	UserRoleValidator userRoleValidator;

	@GetMapping("/")
	public ModelAndView getLandingPage() {
		return new ModelAndView("Index");
	}

	@GetMapping("/register.htm")
	public ModelAndView renderRegistrationPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mv = new ModelAndView();
		if (request.getParameter("role").equals("doctor")) {
			model.addAttribute("doctor", new Doctor());
			mv.setViewName("DoctorRegistration");
		} else {

			model.addAttribute("patient", new Patient());
			mv.setViewName("PatientRegistration");
		}
		return mv;
	}

	@GetMapping("/login.htm")
	public ModelAndView renderLoginPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}

	@PostMapping("/login.htm")
	public ModelAndView renderLandingPage(@ModelAttribute("user") UserRole user, BindingResult result,
			SessionStatus status, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("result" + result);
		userRoleValidator.validate(user, result);

		if (result.hasErrors()) {
			mv.setViewName("Login");
			return mv;
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if (user.getRole().equals("doctor")) {
			DoctorDAO docDAO = new DoctorDAO();
			boolean isAuthorized = docDAO.checkIfAuthorized(user.getEmail(), user.getPassword());
			if (!isAuthorized) {
				ObjectError error = new ObjectError("user", "Invalid email or Password");
				result.addError(error);
				mv.setViewName("Login");
				return mv;
			} else {

				Object doctor = docDAO.getDoctor(user.getEmail(), user.getPassword());
				session.setAttribute("doctor", doctor);
				mv.setViewName("redirect:/doctor/dashboard.htm");
				return mv;
			}

		} else if (user.getRole().equals("patient")) {
			PatientDAO patientDAO = new PatientDAO();
			boolean isAuthorized = patientDAO.checkIfAuthorized(user.getEmail(), user.getPassword());
			System.out.println("isauthorized" + isAuthorized);
			if (!isAuthorized) {
				ObjectError error = new ObjectError("user", "Invalid email or Password");
				result.addError(error);
				mv.setViewName("Login");
				return mv;
			} else {
				session.setAttribute("patient", patientDAO.getPatient(user));
				mv.setViewName("redirect:/patient/dashboard.htm");
				return mv;
			}

		}
		status.setComplete();
		mv.setViewName("redirect:/patient/dashboard.htm");
		return mv;
	}

	@GetMapping("/logout.htm")
	public ModelAndView logoutUser(ModelMap model, UserRole user, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserRole currentUser = (UserRole) session.getAttribute("user");
		if (currentUser != null) {
			if (currentUser.getRole().equals("doctor")) {
				session.removeAttribute("user");
				session.removeAttribute("doctor");
			} else {
				session.removeAttribute("user");
				session.removeAttribute("patient");
			}
		}
		model.addAttribute("user", user);
		mv.setViewName("Login");
		return mv;
	}

	@GetMapping("/test.htm")
	public ModelAndView renderTestPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("DoctorAvailability");
		return mv;
	}
}
