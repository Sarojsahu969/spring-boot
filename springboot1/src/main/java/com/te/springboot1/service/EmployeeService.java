package com.te.springboot1.service;

import com.te.springboot1.bean.EmployeeBean;

public interface EmployeeService {

public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmployee(int id);
	
	public java.util.List<EmployeeBean> getAllData();
	
	public boolean addEmployee(EmployeeBean bean);
	
	public boolean updateEmployee(EmployeeBean bean);

//	EmployeeBean authenticate(int id, String pwd);
}
