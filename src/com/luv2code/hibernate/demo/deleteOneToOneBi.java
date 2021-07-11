package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class deleteOneToOneBi {

	public static void main(String[] args) {

//		create session factory / create only once in whole app 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession(); 

		try {
		
//			start transaction
			System.out.println("Begin session1");
			session.beginTransaction();

//			getting data
			InstructorDetails result=session.get(InstructorDetails.class, 7);
			
			System.out.println(result);
			System.out.println(result.getTheinstructor());
			
//			delete
			session.delete(result);
			
//			make commit
			System.out.println("commit session1");
			session.getTransaction().commit();			
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}
	}

}
