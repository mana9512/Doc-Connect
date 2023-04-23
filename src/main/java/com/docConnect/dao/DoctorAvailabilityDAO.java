package com.docConnect.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import com.docConnect.pojo.DoctorAvailability;

@Component
public class DoctorAvailabilityDAO extends DAO {
	public DoctorAvailabilityDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(DoctorAvailability da) throws Exception {
		try {
			begin();
			getSession().save(da);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Error while saving doctor availability ");
		}
	}
}
