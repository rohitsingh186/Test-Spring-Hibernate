package com.barclays.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import com.barclays.domain.Employee;


public class EmployeeDao {

	public List<Employee> getAllEmployees() {
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Employee> employeeList = session.createQuery("FROM Employee").list();
		
		System.out.println("Number of Employees: " + employeeList.size());
		
		session.getTransaction().commit();
		session.close();
		
		return employeeList ;
		
	}

}
