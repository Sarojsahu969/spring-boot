package com.te.springboot1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.springboot1.bean.EmployeeBean;

import antlr.collections.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	/*
	 * @Override public EmployeeBean authenticate(int id, String pwd) {
	 * EntityManagerFactory factory =
	 * Persistence.createEntityManagerFactory("springdb");
	 * 
	 * EntityManager manager = factory.createEntityManager();
	 * 
	 * try { EmployeeBean bean = manager.find(EmployeeBean.class, id);
	 * 
	 * if (bean != null) { if (bean.getPassword().equals(pwd)) {
	 * System.out.println("login successful"); return bean; } else {
	 * System.out.println("invalid credentials"); return null; } } else {
	 * System.out.println("user not found"); return null; } } catch (Exception e) {
	 * 
	 * e.printStackTrace(); return null; } // end of authenticate
	 * 
	 * }
	 */

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		return bean;
	}

	@Override
	public boolean deleteEmployee(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			return false;
		}

	}// end of delete employee

	@Override
	public java.util.List<EmployeeBean> getAllData() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		String query = "from EmployeeBean";

		javax.persistence.Query query2 = manager.createQuery(query);

		java.util.List<EmployeeBean> list = query2.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		try {

			transaction.begin();

			manager.persist(bean);

			boolean isadded = false;

			if (bean != null) {
				isadded = true;
				transaction.commit();
				return isadded;
			} else {
				isadded = false;
				return isadded;
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}// end of addEmployee method

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return false;
	}
}
