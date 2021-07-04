package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class OneToOneBi {

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
			
//			Instructor theinstructor = new Instructor("naseema", "khatoon", "naseema@gmail.com");
			
//			InstructorDetails theinstructorDetails= new InstructorDetails("www.naseema.com", "house wife");
			
//			theinstructor.setInstructorDetails(theinstructorDetails);
						
//			start transaction
			System.out.println("Begin session1");
			session.beginTransaction();

//			getting data
			InstructorDetails result=session.get(InstructorDetails.class, 5);
			
			System.out.println(result);
			System.out.println(result.getTheinstructor());
			
//			delete
//			Instructor ent = session.load(Instructor.class, 2);
//			session.delete(ent);
			
//			get model data
//			Instructor res=session.get(Instructor.class, 2);
			
//			System.out.println(res);
			
//			make commit
			System.out.println("commit session1");
			session.getTransaction().commit();			
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}
	}

}
