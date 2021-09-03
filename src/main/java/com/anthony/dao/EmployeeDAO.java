package com.anthony.dao;

import java.sql.SQLException;
import java.util.List;

import com.anthony.employee.Employee;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;

public interface EmployeeDAO {
	
	public List<PastReimbursement> viewPastReimbursements(int empID);
	
	public List<Reimbursement> viewAllMyReimbursements();
	
	public void applyForReimbursement(int id, String type, double amount, String description, String date_string);
	
	public Employee employeeLogin(int attemptId, String attemptUsername, String attemptPassword);
	
	public void addToPendingReimbursements(PastReimbursement pastReimbursement);

}
