package com.te.springboot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot1.bean.EmployeeBean;
import com.te.springboot1.dao.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDaoImpl dao;

	/*
	 * @Override public EmployeeBean authenticate(int id, String pwd) {
	 * 
	 * return dao.authenticate(id, pwd); }
	 */

	@Override
	public EmployeeBean getEmployee(int id) {
		
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		
		return dao.deleteEmployee(id);
	}

	@Override
	public List<EmployeeBean> getAllData() {
		
		return dao.getAllData();
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {

		return dao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		
		
		return dao.updateEmployee(bean);
	}
}
