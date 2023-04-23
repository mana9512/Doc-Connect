package com.docConnect.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.docConnect.pojo.AppointmentBooking;
import com.docConnect.pojo.Patient;

@Component
public class AppointmentBookingDAO extends DAO {

	public AppointmentBookingDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(AppointmentBooking ap) throws Exception {
		try {
			begin();
			getSession().save(ap);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Error while saving adding booking ");
		}
	}

	public List<AppointmentBooking> fetchPatientAppointments(Patient p) throws Exception {
		try {
			begin();
			Integer patientId = p.getId();
			Query query = getSession().createQuery("From AppointmentBooking where patient=:patient");
			query.setParameter("patient", p);
			List<AppointmentBooking> appointments = query.list();
			commit();
			System.out.println("appointmetns" + appointments.toString());
			return appointments;
		} catch (HibernateException e) {
			rollback();
			return null;
		}

	}

}
