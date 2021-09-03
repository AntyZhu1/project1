package com.anthony.employee;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table (name = "employees")

public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	@Column(name = "emp_username", length = 100)
	private String emp_username;
	
	@Column(name = "emp_password", length = 50)
	private String emp_password;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_username() {
		return emp_username;
	}
	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_username=" + emp_username + ", emp_password=" + emp_password + "]";
	}
	
	public Employee() {
		super();
	}
	
	public Employee(int emp_id, String emp_username, String emp_password) {
		super();
		this.emp_id = emp_id;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
	}

	

}
