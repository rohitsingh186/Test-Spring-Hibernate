package com.barclays.factory;

import com.barclays.dao.EmployeeDao;

public class DaoFactory {
	
	private static final EmployeeDao empDao = new EmployeeDao();
	
	public static EmployeeDao getEmployeeDao(){
		return empDao;
	}
}
