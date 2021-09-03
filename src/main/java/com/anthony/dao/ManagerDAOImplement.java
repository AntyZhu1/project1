package com.anthony.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anthony.employee.Employee;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;
import com.anthony.loadData.LoadAllData;
import com.anthony.manager.Manager;

public class ManagerDAOImplement implements ManagerDAO{

	public Manager mangerLogin(int attemptId, String attemptUsername, String attemptPassword) {
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
        
        
		Manager tempMan = session.get(Manager.class, attemptId);

        
        t.commit();
        session.close();
		factory.close();
		return tempMan;
	}

	public void approveReimbursement(int re_id) {
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
        Reimbursement past = session.get(Reimbursement.class, re_id);
        
		PastReimbursement pending = session.get(PastReimbursement.class, re_id);
		
		pending.setPast_approve_status("Approved");

        session.update(pending);
        
        session.delete(past);
		
        t.commit();
        session.close();
		factory.close();
		
	}

	public void denyReimbursement(int re_id) {
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
        Reimbursement past = session.get(Reimbursement.class, re_id);
        
		PastReimbursement pending = session.get(PastReimbursement.class, re_id);
		
		pending.setPast_approve_status("Denied");

        session.update(pending);
        
        session.delete(past);
		
        t.commit();
        session.close();
		factory.close();
		
	}

	public void filterReimbursementByStatus(String status) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<PastReimbursement> viewPastReimbursements() {
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





}
