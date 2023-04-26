package com.docConnect.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.docConnect.exception.DocConnectException;
import com.docConnect.pojo.*;

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
			throw new Exception("Error while saving booking ");
		}
	}

	public List<AppointmentBooking> fetchAppointments(Object obj) throws Exception {
		try {
			begin();
			Query query;
			LocalDate localDate = LocalDate.now();
			java.sql.Date currentDate = java.sql.Date.valueOf(localDate);


			if(obj instanceof Patient) {
				Patient patient = (Patient) obj;
				
				query = getSession().createQuery("FROM AppointmentBooking a WHERE a.id NOT IN ( SELECT c.appointmentId FROM CancelledAppointment c) AND a.patient=:patient AND a.appointmentDate >= :currentDate");
				query.setParameter("patient", patient);
			} else {
				Doctor doc = (Doctor) obj;
				query = getSession().createQuery("FROM AppointmentBooking a WHERE a.id NOT IN ( SELECT c.appointmentId FROM CancelledAppointment c) AND a.doctor=:doctor AND a.appointmentDate >= :currentDate");
				query.setParameter("doctor", doc);
			}
			query.setParameter("currentDate", currentDate);
			
			List<AppointmentBooking> appointments = query.list();
			commit();
			System.out.println("appointmetns" + appointments.toString());
			return appointments;
		} catch (HibernateException e) {
			rollback();
			return null;
		}

	}
	
	public AppointmentBooking getAppointmentById(Integer id) throws DocConnectException {

		try {
			begin();
			String hql = "From AppointmentBooking where id=" + id;
			System.out.println(hql);
			@SuppressWarnings("rawtypes")
			Query q = getSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<AppointmentBooking> app = q.list();

			if (app.size() == 0) {
				rollback();
				return null;
			}

			commit();
			return app.get(0);
		} catch (HibernateException e) {
			rollback();
			throw new DocConnectException("Cannot find a appointment with specified Id", e);
		}
	}

}
