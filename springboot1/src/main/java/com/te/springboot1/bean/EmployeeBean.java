package com.te.springboot1.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@JsonRootName("employee-info")
@JsonPropertyOrder({"id" , "name"})
@XmlRootElement(name = "employee-info")
@Table(name = "employee_info")
public class EmployeeBean implements Serializable {

	@Id
	@Column
	@JsonProperty("emp_id")
	private int  id;
	
	@Column
	private String name;
	
	@Column(name = "dob")
	private Date birtDate;
	
//	@JsonIgnore
//	@XmlTransient
	@Column
	private String password;
	
}