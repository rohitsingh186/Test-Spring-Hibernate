package com.barclays.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;

import com.barclays.domain.Address;
import com.barclays.domain.Email;
import com.barclays.domain.Employee;

public class EmployeeDao {

	private List<Employee> employees;

	public EmployeeDao() {
		employees = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Rohitwa");
		
		Address addr1 = new Address();
		addr1.setId(10);
		addr1.setCity("Pune");
		addr1.setEmployee(emp1);
		
		Email email1 = new Email();
		email1.setId(100);
		email1.setEmail("rohit1@gmail.com");
		email1.setEmployee(emp1);
		
		Email email2 = new Email();
		email2.setId(101);
		email2.setEmail("rohit2@gmail.com");
		email2.setEmployee(emp1);
		
		emp1.setAddress(addr1);
		
		Set<Email> emails = new TreeSet<Email>();
		emails.add(email1);
		emails.add(email2);
		
		emp1.setEmails(emails);
		
		employees.add(emp1);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	/*
	 * public void setEmployees(List<Employee> employees) { this.employees =
	 * employees; }
	 */

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

}
