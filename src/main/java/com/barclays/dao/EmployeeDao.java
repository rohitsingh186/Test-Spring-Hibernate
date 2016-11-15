package com.barclays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.barclays.domain.Employee;

public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getAllEmployees() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println("List size is: " + (criteria.list().size()));

		session.getTransaction().commit();
		session.close();
		
		return criteria.list();

	}

}
