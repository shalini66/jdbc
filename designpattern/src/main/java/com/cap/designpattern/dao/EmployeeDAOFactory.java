package com.cap.designpattern.dao;

public class EmployeeDAOFactory {

	private EmployeeDAOFactory() {}
	
	private static String dbInteractionType = "jdbc";
	public static EmployeeDAO getInstance() {
		EmployeeDAO dao = null;
		if(dbInteractionType.equals("jdbc")) {
			dao=  new EmployeeDAOJDBCImplement();
		} else if(dbInteractionType.equals("hibernate")) {
			dao = new EmployeeJPAHibernateDAOImplements();
		} else {
			dao = new EmployeeDAOSpringImplements();
		}
		return dao;
	}
}
