package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.insert_quary.Student;

public class StateDemp {

	public static void main(String[] args) {

		// private of Hibernate object States
		// Transaction
		// Persistent
		// Detached
		// Remove
		System.out.println("Example...!");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student=new Student();
		student.setId(345);
		student.setName("Donald");
		student.setCity("Hazaribagh");
		
		//Student : Transient
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		//Student : persistent - session,daabase
		student.setName("Caif");
		tx.commit();
		s.close();
		//student :Detached
		student.setName("Sachin");
		System.out.println(student);
		f.close();
	}
}
