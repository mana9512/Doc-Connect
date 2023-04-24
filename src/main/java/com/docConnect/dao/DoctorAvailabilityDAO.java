package com.docConnect.dao;

import java.util.*;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.docConnect.exception.DocConnectException;
import com.docConnect.pojo.Doctor;
import com.docConnect.pojo.DoctorAvailability;

@Component
public class DoctorAvailabilityDAO extends DAO {
	public DoctorAvailabilityDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(DoctorAvailability da) throws DocConnectException {
		try {
			begin();
			getSession().save(da);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new DocConnectException("Error while saving doctor availability ");
		}
	}
	
	public List<DoctorAvailability> fetchAvailabilities(Doctor doctor) throws DocConnectException {
		try {
			begin();
			Query query = getSession().createQuery("from DoctorAvailability where doctor=:doctor");
			query.setParameter("doctor", doctor);
			List<DoctorAvailability> timings = query.list();
			commit();
			return timings;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
	}
}
