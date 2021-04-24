package com.te.springboot1.dao;

import com.te.springboot1.bean.EmployeeBean;

public interface EmployeeDao {

//	public EmployeeBean authenticate(int id, String pwd);

	public EmployeeBean getEmployee(int id);

	public boolean deleteEmployee(int id);

	public java.util.List<EmployeeBean> getAllData();

	public boolean addEmployee(EmployeeBean bean);

	public boolean updateEmployee(EmployeeBean bean);
}
