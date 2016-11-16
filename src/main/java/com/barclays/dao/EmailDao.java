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

import com.barclays.domain.Email;
import com.barclays.domain.Employee;

@Repository
public class EmailDao {

    private SessionFactory sessionFactory;
 
	public List<Email> getAllEmails() {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		this.sessionFactory = (SessionFactory) appContext.getBean("sessionFactory");
		System.out.println("Session Factory: " + (this.sessionFactory != null));

		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		List<Email> emailList = session.createQuery("FROM Email").list();

		System.out.println("Number of Emails: " + emailList.size());

		session.getTransaction().commit();
		session.close();

		return emailList;

	}

}
