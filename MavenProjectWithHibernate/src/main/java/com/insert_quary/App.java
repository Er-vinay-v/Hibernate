package com.insert_quary;

//import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
//	private static FileInputStream file;

	public static void main(String[] args)  {
		System.out.println("Project started...!");

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
//        Session factory = new Configuration().configure().buildSessionFactory().openSession();

		// =creating student
		Student st = new Student();
		st.setId(102);
		st.setName("Ronaldo");
		st.setCity("Argentina");

		System.out.println(st);

		Student st1 = new Student();
		st1.setId(103);
		st1.setName("Virath Kohli");
		st1.setCity("Delhi");
		System.out.println(st1);

		Student st2 = new Student();
		st2.setId(104);
		st2.setName("Dhoni");
		st2.setCity("Ranchi");
		System.out.println(st2);

		// Creating Address

		Address a = new Address();
		a.setCity("Mumbai");
		a.setStreet("Street_11");
		a.setOpen(true);
		a.setAddedDate(new Date());
		a.setX(1234.234);

		Address a1 = new Address();
		a1.setCity("Delhi");
		a1.setStreet("Street_10");
		a1.setOpen(true);
		a1.setAddedDate(new Date());
		a1.setX(1234.234);

//		file = new FileInputStream(
//				"src/main/java/com/insert_quary/photo.png");
//		byte[] data = new byte[file.available()];
//		a.setImage(data);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(st);
		session.save(st1);
		session.save(st2);
		session.save(a);
		session.save(a1);

		tx.commit();
		session.close();
		System.out.println("Done...!");
	}
}
