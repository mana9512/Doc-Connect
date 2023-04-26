package com.docConnect.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.docConnect.exception.DocConnectException;
import com.docConnect.pojo.CancelledAppointment;
import com.docConnect.pojo.Doctor;

@Component
public class CancelledAppointmentDAO extends DAO {
	public CancelledAppointmentDAO() {
		super();
	}

	public void save(CancelledAppointment ca) throws DocConnectException {
		try {
			begin();
			getSession().save(ca);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new DocConnectException("Error while saving cancelled appointment ");
		}
	}
	
	public List<CancelledAppointment> fetchCancelledAppointments(Doctor d) throws Exception {
		try {
			begin();
			Query query = getSession().createQuery("From CancelledAppointment where doctor=:doctor");
			query.setParameter("doctor", d);
			List<CancelledAppointment> cancelledAppointments = query.list();
			commit();
			System.out.println("cancelledAppointments" + cancelledAppointments.toString());
			return cancelledAppointments;
		} catch (HibernateException e) {
			rollback();
			return null;
		}

	}

}
