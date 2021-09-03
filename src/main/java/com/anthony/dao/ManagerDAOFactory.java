package com.anthony.dao;

public class ManagerDAOFactory {
	 private static ManagerDAO dao;
	 
	 private ManagerDAOFactory() {
		 
	 }
	 public static ManagerDAO getManagerDao() {
		 if (dao == null) {
			 dao = new ManagerDAOImplement();
		 }
		 
		 return dao;
	 }
}
