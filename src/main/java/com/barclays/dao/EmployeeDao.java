package com.barclays.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.barclays.domain.Address;
import com.barclays.domain.Email;
import com.barclays.domain.Employee;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;

public class EmployeeDao {

	@Autowired
	private DataSource dataSource;

	private List<Employee> employees;
	

	public EmployeeDao() {
		
		this.employees = new ArrayList<Employee> ();

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(appContext);

		this.dataSource = (DataSource) appContext.getBean("dataSource");

	}

	public List<Employee> getEmployees() {

		employees = new ArrayList<Employee> ();
		
		generateEmployees();
		generateAddress();
		generateEmails();

		return employees;
		
	}
	
	private void generateEmails(){
		
		try {

			Connection dbConnection = dataSource.getConnection();
			System.out.println("Connection successful: " + (dataSource != null));
			
			String selectQuery = "SELECT e.id, e.email, e.employee_id FROM email e";
			
			try (Statement selectSt = dbConnection.createStatement()){
				
				ResultSet result = selectSt.executeQuery(selectQuery);
				
				while (result.next()) {
					
					int id = result.getInt("id");
					String email = result.getString("email");
					int employeeId = result.getInt("employee_id");
					
					Email emailOb = new Email();
					emailOb.setId(id);
					emailOb.setEmail(email);
					emailOb.setEmployee(getEmployee(employeeId));
					
					getEmployee(employeeId).addEmail(emailOb);
					
				}
				
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void generateAddress() {
		try {

			Connection dbConnection = dataSource.getConnection();
			System.out.println("Connection successful: " + (dataSource != null));
			
			String selectQuery = "SELECT a.id, a.city, a.employee_id FROM address a";
			
			try (Statement selectSt = dbConnection.createStatement()){
				
				ResultSet result = selectSt.executeQuery(selectQuery);
				
				while (result.next()) {
					
					int id = result.getInt("id");
					String city = result.getString("city");
					int employeeId = result.getInt("employee_id");
					
					Address address = new Address();
					address.setCity(city);
					address.setEmployee(getEmployee(employeeId));
					
					getEmployee(employeeId).setAddress(address);
					
				}
				
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void generateEmployees() {
		try {

			Connection dbConnection = dataSource.getConnection();
			System.out.println("Connection successful: " + (dataSource != null));
			
			String selectQuery = "SELECT e.id, e.name, e.brid, e.manager_id FROM employee e";
			
			try (Statement selectSt = dbConnection.createStatement()){
				
				ResultSet result = selectSt.executeQuery(selectQuery);
				
				while (result.next()) {
					
					int id = result.getInt("id");
					String name = result.getString("name");
					String brid = result.getString("brid");
					int managerId = result.getInt("manager_id");
					
					Employee emp = new Employee();
					emp.setId(id);
					emp.setName(name);
					emp.setBrid(brid);
					emp.setManager(getEmployee(managerId));
					
					employees.add(emp);
					
				}
				
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void setEmployees(List<Employee> employees) { this.employees =
	 * employees; }
	 */
	
	public Employee getEmployee(int id) {
		
		for (Employee e: employees) {
			if (e.getId() == id) {
				return e;
			}
		}
		
		return null;
		
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

}
