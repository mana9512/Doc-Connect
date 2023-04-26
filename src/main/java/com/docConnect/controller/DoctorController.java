package com.docConnect.controller;

import java.text.*;
import java.time.LocalDateTime;
import java.util.List;

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
import com.docConnect.exception.DocConnectException;
import com.docConnect.pojo.*;
import com.docConnect.validators.DoctorValidator;

@RestController
public class DoctorController {
	@Autowired
	DoctorValidator docvalidator;
	
	@PostMapping("/register/doctor.htm")
	public ModelAndView registerDoctorAccount(@ModelAttribute("doctor") Doctor doctor, BindingResult result, SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		docvalidator.validate(doctor, result);

		if (result.hasErrors()) {
			//redirect:/register.htm?role=doctor
			mv.setViewName("DoctorRegistration");
			return mv;
		}
		status.setComplete();

		DoctorDAO docDao = new DoctorDAO();

		// New Code
		Query q = docDao.getSession().createQuery("Select email From Doctor");
		List<String> emailIdList = q.getResultList();
		if (emailIdList.contains(doctor.getEmail())) {
			ObjectError error = new ObjectError("doctor", "User with same email already exists ");
			result.addError(error);
			mv.setViewName("DoctorRegistration");
			return mv;
		}
		System.out.println("doctor"+doctor.toString());
		docDao.save(doctor);
		request.setAttribute("name", doctor.getName());
		mv.setViewName("DoctorDashboard");
		return mv;
	}
	
	@GetMapping("/doctor/dashboard.htm")
	public ModelAndView renderDoctorHomePage(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("DoctorDashboard");
		return mv;
	}
	
	@PostMapping("/doctor/add/availability.htm")
	public ModelAndView addAvailability(@ModelAttribute("availability") DoctorAvailability availability, BindingResult result, SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession();
		Doctor doctor=(Doctor)session.getAttribute("doctor");
		availability.setDoctor(doctor);
		String timeString = request.getParameter("availableTime"); // 24-hour format string
		java.text.SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		java.util.Date parsed = format.parse(timeString);
		java.sql.Time time = new java.sql.Time(parsed.getTime());
		availability.setAvailableTime(time);
		System.out.println("----avail----"+ availability.toString()+"time"+request.getParameter("availableTime"));
		DoctorAvailabilityDAO da = new DoctorAvailabilityDAO();
		da.save(availability);
		mv.setViewName("redirect:/doctor/availabilities.htm");
		return mv;
	}
	
	@GetMapping("/doctor/add/availability.htm")
	public ModelAndView viewAddAvailability(@ModelAttribute("availability") DoctorAvailability availability, BindingResult result, SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("DoctorAddAvailability");
		return mv;
	}
	
	@GetMapping("/doctor/appointments.htm")
	public ModelAndView renderDoctorAppointments(@ModelAttribute("availability") DoctorAvailability availability, BindingResult result, SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		AppointmentBookingDAO appdao = new AppointmentBookingDAO();
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		System.out.print("---------doctor---------" + doctor);
		List<AppointmentBooking> appointments = appdao.fetchAppointments(doctor);
		mv.addObject("appointments", appointments);
		mv.setViewName("DoctorAppointments");
		return mv;
	}
	
	@GetMapping("/doctor/availabilities.htm")
	public ModelAndView renderDoctorAvailabilities(@ModelAttribute("availability") DoctorAvailability availability, BindingResult result, SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		DoctorAvailabilityDAO docAvailability = new DoctorAvailabilityDAO();
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		System.out.println("---------doctor---------" + doctor);
		List<DoctorAvailability> availabilities = docAvailability.fetchAvailabilities(doctor);
		System.out.println("-----availabilities-----"+availabilities);
		mv.addObject("availabilities", availabilities);
		mv.setViewName("DoctorViewAvailabilities");
		return mv;
	}
	
	
	@GetMapping("/doctor/cancel-appointment.htm")
	public ModelAndView renderCancelAppointmentPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mv = new ModelAndView();
		Integer appointmentId = Integer.parseInt(request.getParameter("id"));
		AppointmentBookingDAO appdao = new AppointmentBookingDAO();
		AppointmentBooking booking = null;
		try {
			booking = appdao.getAppointmentById(appointmentId);
		} catch (DocConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("booking", booking);
		mv.setViewName("CancelAppointment");
		return mv;
	}
	
	@PostMapping("/doctor/cancel-appointment.htm")
	public ModelAndView cancelAppointment(@ModelAttribute("cancelled") CancelledAppointment cancelled, BindingResult result, SessionStatus status, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Integer appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		System.out.println("---appointment-id----"+appointmentId);
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		AppointmentBookingDAO appdao = new AppointmentBookingDAO();
		AppointmentBooking appointment = appdao.getAppointmentById(appointmentId);
		cancelled.setAppointment(appointment);
		cancelled.setCancelledDate(LocalDateTime.now());
		cancelled.setDoctor(doctor);
		CancelledAppointmentDAO cdao = new CancelledAppointmentDAO();
		System.out.println("--cancelled appointment data-->"+cancelled);
		cdao.save(cancelled);
		mv.setViewName("redirect:/doctor/cancelled-appointments.htm");
		return mv;
	}
	
	@GetMapping("/doctor/cancelled-appointments.htm")
	public ModelAndView renderDoctorCancelledAppointments(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		CancelledAppointmentDAO cancelDao = new CancelledAppointmentDAO();
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		List<CancelledAppointment> appointments = cancelDao.fetchCancelledAppointments(doctor);
		mv.addObject("cancelledAppointments", appointments);
		mv.setViewName("DoctorCancelledAppointments");
		return mv;
	}

}
