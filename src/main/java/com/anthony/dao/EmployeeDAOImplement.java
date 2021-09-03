package com.anthony.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anthony.employee.Employee;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;
import com.anthony.loadData.LoadAllData;

public class EmployeeDAOImplement implements EmployeeDAO{

	public EmployeeDAOImplement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<PastReimbursement> viewPastReimbursements(int empID) {
		// create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
//        Transaction t = session.beginTransaction();
        
		List<PastReimbursement> pastTransactions = LoadAllData.loadAllData(PastReimbursement.class, session);
		
		session.close();
		factory.close();
        
		return pastTransactions;
	}

	public void applyForReimbursement(int id, String type, double amount, String description, String date_string) {
		// create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
        Reimbursement reimbursementApplication = new Reimbursement(id, type, amount, description, date_string);
		
		session.save(reimbursementApplication);
		
//		List<Reimbursement> pastReimbursements = LoadAllData.loadAllData(Reimbursement.class, session);
		
//		Reimbursement mostRecent = pastReimbursements.get(pastReimbursements.size() - 1);
		
//		int recentReimbursementId = mostRecent.getRe_id();
//		
//		PastReimbursement reimbursementRecord = new PastReimbursement(recentReimbursementId, id, type, amount, description, date_string, "pending");
//		
//		session.save(reimbursementRecord);

		t.commit();
        // close the session
        session.close();
		factory.close();

		
	}

	public Employee employeeLogin(int attemptId, String attemptUsername, String attemptPassword) {
		// create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
        
		Employee tempEmp = session.get(Employee.class, attemptId);

        
        t.commit();
        session.close();
		factory.close();

		return tempEmp;
		
	}

	public List<Reimbursement> viewAllMyReimbursements() {
		// create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();

		List<Reimbursement> pastReimbursements = LoadAllData.loadAllData(Reimbursement.class, session);

        
        session.close();
		factory.close();

        
		return pastReimbursements;
	}

	public void addToPendingReimbursements(PastReimbursement pastReimbursement) {
		
		// create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
		session.save(pastReimbursement);
		
		t.commit();
        // close the session
        session.close();
		factory.close();


		
	}






}
