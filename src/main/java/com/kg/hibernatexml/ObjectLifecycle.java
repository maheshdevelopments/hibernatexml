package com.kg.hibernatexml;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ObjectLifecycle {

	public static void main(String[] args) {

		// 'emp' object is in 'TRANSIENT' state.
		Employee emp = new Employee();
		emp.setId(2);
		emp.setFirstName("John");
		emp.setLastName("Patrick");

		// Creating the config instance & passing the hibernate config file.
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		// Session object to start the db transaction.
		Session s = config.buildSessionFactory().openSession();

		// Transaction object to begin the db transaction.
		Transaction t = s.beginTransaction();

		// Here 'emp' object is in 'PERSISTENT' state.
		s.save(emp);

		// 'emp' object will be saved to the database.
		t.commit();

		// Closing the session object. 'emp' object is in 'DETACHED' object.
		s.close();
	}
}