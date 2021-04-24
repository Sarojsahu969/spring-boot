package com.te.springboot1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot1.bean.EmployeeBean;
import com.te.springboot1.bean.EmployeeResponse;
import com.te.springboot1.service.EmployeeService;

@RestController
public class SpringBootController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public String firstHandlerMethod() {
		return "TechnoElevate";
	}

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmp(int id) {
		EmployeeResponse response = new EmployeeResponse();
		EmployeeBean employeeBean = empService.getEmployee(id);
		if (employeeBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found");
			response.setBean(employeeBean);

		} else {
			response.setStatusCode(404);
			response.setMsg("fail");
			response.setDescription("Data Not Found");
		}
		return response;
	}

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee() {
		List<EmployeeBean> employeeBean = empService.getAllData();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (employeeBean != null) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription("Data founded");
			employeeResponse.setEmployeeBeans(employeeBean);
		} else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription("Error Data Not found");
		}
		return employeeResponse;
	}// end of getEmp

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {

		EmployeeResponse response = new EmployeeResponse();
		if (empService.addEmployee(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Dsata Added ");
		} else {
			response.setStatusCode(404);
			response.setMsg(" fail");
			response.setDescription("data already present");
		}
		return response;

	}
	
	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id") int id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (empService.deleteEmployee(id)) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Data Deleted for id : " + id);
		} else {
			employeeResponse.setStatusCode(400);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription(" Data Not for id : " + id);
		}

		return employeeResponse;
	}//

}
