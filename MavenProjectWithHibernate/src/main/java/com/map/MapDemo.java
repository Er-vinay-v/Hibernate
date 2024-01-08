package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

//	Create question

		Question q = new Question();
		q.setQuestionid(101);
		q.setQuestion("What is java ?");

		// Create answer

		Answer ans = new Answer();
		ans.setAnswerid(321);
		ans.setAnswer("Java is a programing language.");
//		q.setAnswer(ans);
		ans.setQuestion(q);

		Answer ans2 = new Answer();
		ans2.setAnswerid(329);
		ans2.setAnswer("Java is an object oriented programming language.");
//		q.setAnswer(ans);
		ans2.setQuestion(q);

		Answer ans3 = new Answer();
		ans3.setAnswerid(345);
		ans3.setAnswer("Java has different types of frame works.");
//		q.setAnswer(ans);
		ans3.setQuestion(q);

		List<Answer> list = new ArrayList<Answer>();
		list.add(ans);
		list.add(ans2);
		list.add(ans3);
		q.setAnswers(list);

		// Create question
//		Question q2 = new Question();
//		q2.setQuestionid(112);
//		q2.setQuestion("what is hibernate  ?");

		// create answer
//		Answer ans2 = new Answer();
//		ans2.setAnswerid(301);
//		ans2.setAnswer("Hibernae is object relational base mapping.");
//		ans2.setQuestion(q2);
//		q2.setAnswer(ans2);

		// session

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

//		s.save(q);
//		s.save(q2);
//		s.save(ans);
//		s.save(ans2);

		s.save(q);
        s.save(ans);
        s.save(ans2);
        s.save(ans3);
        
        //lazy loading fetching
        Question qu=(Question)s.get(Question.class, 101);
        System.out.println(qu.getQuestionid());
        System.out.println(qu.getQuestion());
        System.out.println(qu.getAnswers().size());
        
		tx.commit();

		// fetching
//		Question newQ = (Question) s.get(Question.class, 112);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer().getAnswer());

		s.close();

		factory.close();
		System.out.println("Done...");
	}
}
