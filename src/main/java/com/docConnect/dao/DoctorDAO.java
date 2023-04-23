package com.docConnect.dao;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import com.docConnect.pojo.*;
import com.docConnect.exception.*;

@Component
public class DoctorDAO extends DAO {

	public DoctorDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Doctor doc) throws Exception {
		try {
			begin();
			getSession().save(doc);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Error while saving doctor ");
		}
	}

	public Doctor getDoctor(String email, String password) throws DocConnectException {

		try {
			begin();
			String hql = "From Doctor where email='" + email + "' and password='" + password + "'";
			System.out.println(hql);
			@SuppressWarnings("rawtypes")
			Query q = getSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Doctor> use = q.list();

			if (use.size() == 0) {
				rollback();
				return null;
			}

			commit();
			return use.get(0);
		} catch (HibernateException e) {
			rollback();
			throw new DocConnectException("Could not find a user with the given combination", e);
		}
	}

	public Doctor getDoctorById(Integer id) throws DocConnectException {

		try {
			begin();
			String hql = "From Doctor where id=" + id;
			System.out.println(hql);
			@SuppressWarnings("rawtypes")
			Query q = getSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Doctor> docc = q.list();

			if (docc.size() == 0) {
				rollback();
				return null;
			}

			commit();
			return docc.get(0);
		} catch (HibernateException e) {
			rollback();
			throw new DocConnectException("Cannot find a doctor with specified Id", e);
		}
	}

	public boolean checkIfAuthorized(String email, String password) {
		// TODO Auto-generated method stub
		try {
			begin();
			Query query = getSession().createQuery("from Doctor d where d.email = :email AND d.password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			Doctor doc = (Doctor) query.uniqueResult();
			if (doc != null) {
				commit();
				return true;
			} else {
				commit();
				return false;
			}

		} catch (HibernateException e) {
			System.out.print(e);
			rollback();
			return false;
		}
	}

}
