package com.docConnect.dao;

import java.util.*;
import java.sql.Date;
import java.sql.Time;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.docConnect.pojo.Doctor;
import com.docConnect.pojo.DoctorAvailability;
import com.docConnect.pojo.Patient;
import com.docConnect.pojo.UserRole;

public class PatientDAO extends DAO {

	public boolean checkIfAuthorized(String email, String password) {
		// TODO Auto-generated method stub
		try {
			System.out.println("in check authorized");
			begin();
			Query query = getSession().createQuery("from Patient p where p.email = :email AND p.password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			Patient pat = (Patient) query.uniqueResult();
			System.out.println("patient" + pat);
			if (pat != null) {
				return true;
			} else {
				return false;
			}

		} catch (HibernateException e) {
			rollback();
			return false;
		}
	}

	public Patient getPatient(UserRole user) {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		Query query = getSession().createQuery("From Patient where email=:email");
		query.setParameter("email", email);
		Patient patient = (Patient) query.uniqueResult();
		System.out.println("patient" + patient.toString());
		close();
		return patient;
	}

	public void save(Patient pat) throws Exception {
		try {
			begin();
			getSession().save(pat);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Error while saving patient ");
		}
	}

	public List<DoctorAvailability> fetchAppointments() {
		try {
			begin();
			Query query = getSession().createQuery("from DoctorAvailability");
			List<DoctorAvailability> timings = (List<DoctorAvailability>) query.list();
			for (DoctorAvailability timing : timings) {
				// Doctor d = timing.getDoctor();
				// System.out.println("Doctor Name: " + d);
				System.out.println("Date: " + timing.toString());

			}
			commit();
			return timings;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
	}

}
