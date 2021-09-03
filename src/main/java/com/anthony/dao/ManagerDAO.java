package com.anthony.dao;

import java.sql.SQLException;
import java.util.List;

import com.anthony.employee.Employee;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;
import com.anthony.manager.Manager;

public interface ManagerDAO {
	
	public Manager mangerLogin(int attemptId, String attemptUsername, String attemptPassword);
	
//	public void getReimbursementsByEmployee(int emp_id) throws SQLException;
	
	public void approveReimbursement(int re_id);
	
	public void denyReimbursement(int re_id);
	
	public void filterReimbursementByStatus (String status) throws SQLException;
	
	public List<PastReimbursement> viewPastReimbursements();
	

}
