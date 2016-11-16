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

import com.barclays.domain.Address;
import com.barclays.domain.Employee;

@Repository
public class AddressDao {

    private SessionFactory sessionFactory;
 
	public List<Address> getAllAddresses() {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		this.sessionFactory = (SessionFactory) appContext.getBean("sessionFactory");
		System.out.println("Session Factory: " + (this.sessionFactory != null));

		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		List<Address> addressList = session.createQuery("FROM Address").list();

		System.out.println("Number of Addresses: " + addressList.size());

		session.getTransaction().commit();
		session.close();

		return addressList;

	}

}
