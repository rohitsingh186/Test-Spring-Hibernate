package com.barclays.factory;

import com.barclays.dao.AddressDao;
import com.barclays.dao.EmailDao;
import com.barclays.dao.EmployeeDao;

public class DaoFactory {
	
	private static final EmployeeDao empDao = new EmployeeDao();
	private static final AddressDao addressDao = new AddressDao();
	private static final EmailDao emailDao = new EmailDao();
	
	public static EmployeeDao getEmployeeDao(){
		return empDao;
	}
	
	public static AddressDao getAddressDao(){
		return addressDao;
	}
	
	public static EmailDao getEmailDao(){
		return emailDao;
	}
	
}
