package com.docConnect.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

import javax.servlet.http.*;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.docConnect.dao.*;
import com.docConnect.pojo.*;
import com.docConnect.validators.PatientValidator;

@RestController
public class PatientController {
	@Autowired
	PatientValidator patientValidator;

	@PostMapping("/register/patient.htm")
	public ModelAndView registerPatient(@ModelAttribute("patient") Patient patient, BindingResult result,
			SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		patientValidator.validate(patient, result);
		System.out.println("errors"+result);
		if (result.hasErrors()) {
			mv.setViewName("PatientRegistration");
			return mv;
		}
		status.setComplete();

		PatientDAO patientDao = new PatientDAO();

		// New Code
		Query q = patientDao.getSession().createQuery("Select email From Patient");
		List<String> emailIdList = q.getResultList();
		if (emailIdList.contains(patient.getEmail())) {
			ObjectError error = new ObjectError("patient", "User with same email already exists ");
			result.addError(error);
			mv.setViewName("PatientRegistration");
			return mv;
		}
		patientDao.save(patient);
		request.setAttribute("name", patient.getName());
		mv.setViewName("PatientDashboard");
		return mv;
	}

	@GetMapping("/appointment.htm")
	public ModelAndView fetchDoctorAvailability(@ModelAttribute("patient") Patient patient, BindingResult result,
			SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();

		PatientDAO patientDao = new PatientDAO();

		List<DoctorAvailability> timings = patientDao.fetchDoctorAvailabilities();
		HashMap<Doctor, HashMap<Date, List<Time>>> doctorAvailabilities = new HashMap<>();
		for (DoctorAvailability availability : timings) {
			Doctor doctor = availability.getDoctor();
			Date date = availability.getAvailableDate();
			Time time = availability.getAvailableTime();

			if (!doctorAvailabilities.containsKey(doctor)) {
				doctorAvailabilities.put(doctor, new HashMap<Date, List<Time>>());
			}
			if (!doctorAvailabilities.get(doctor).containsKey(date)) {
				doctorAvailabilities.get(doctor).put(date, new ArrayList<Time>());
			}
			doctorAvailabilities.get(doctor).get(date).add(time);
		}
		System.out.println("hashmap" + doctorAvailabilities.toString());
		for (Doctor doctor : doctorAvailabilities.keySet()) {
			HashMap<Date, List<Time>> times = doctorAvailabilities.get(doctor);

			for (Date d : times.keySet()) {
				System.out.println("date:" + d);
				System.out.println("time: " + times.get(d));
			}

		}
		mv.addObject("doctorAvailabilities", doctorAvailabilities);
		mv.setViewName("BookAppointment");
		// BookAppointment
		return mv;
	}

	@PostMapping("/scheduleAppointment.htm")
	public ModelAndView bookappointment(@ModelAttribute("booking") AppointmentBooking booking, BindingResult result,
			SessionStatus status, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		DoctorDAO docdao = new DoctorDAO();
		Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
		Doctor d = docdao.getDoctorById(doctorId);
		System.out.println("---doc---"+d.toString());
		Patient patient = (Patient) session.getAttribute("patient");
		booking.setPatient(patient);
		booking.setDoctor(d);
		System.out.println("---bookin---"+booking);
		AppointmentBookingDAO dao = new AppointmentBookingDAO();
		dao.save(booking);
		status.setComplete();
		mv.setViewName("redirect:/upcoming/appointments.htm");
		return mv;
	}

	@GetMapping("/patient/dashboard.htm")
	public ModelAndView renderPatientDashboard(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("PatientDashboard");
		return mv;
	}

	@GetMapping("/upcoming/appointments.htm")
	public ModelAndView renderPatientUpcomingAppointments(HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		AppointmentBookingDAO appdao = new AppointmentBookingDAO();
		Patient patient = (Patient) session.getAttribute("patient");
		System.out.print("---------patient---------" + patient);
		List<AppointmentBooking> appointments = appdao.fetchAppointments(patient);
		mv.setViewName("PatientUpcomingAppointments");
		mv.addObject("appointments", appointments);
		return mv;
	}

}
