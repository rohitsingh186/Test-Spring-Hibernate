package com.barclays.dao;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.barclays.domain.Employee;

@Repository
public class EmployeeDao {

    private SessionFactory sessionFactory;
 
	public List<Employee> getAllEmployees() {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(appContext);
		
		DataSource ds = (DataSource) appContext.getBean("dataSource");
		try {
			System.out.println("Connection: " + (ds.getConnection() != null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PropertyPlaceholderConfigurer pc = (PropertyPlaceholderConfigurer) appContext.getBean("propertyConfigurer");
		System.out.println("Property Config: " + (pc != null));
		
		
		this.sessionFactory = (SessionFactory) appContext.getBean("sessionFactory");
		System.out.println("Session Factory: " + (this.sessionFactory != null));

		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		List<Employee> employeeList = session.createQuery("FROM Employee").list();

		System.out.println("Number of Employees: " + employeeList.size());

		session.getTransaction().commit();
		session.close();

		return employeeList;

	}

}
