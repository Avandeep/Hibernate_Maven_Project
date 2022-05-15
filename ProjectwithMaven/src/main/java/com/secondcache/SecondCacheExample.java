package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		
		Student stu1= s.get(Student.class,120);
		System.out.println(stu1);
		
		
		
		System.out.println(s.contains(stu1));
		
		s.close();
		
Session s1=factory.openSession();
		
		
		
		
		Student stu2= s1.get(Student.class,120);
		System.out.println(stu2);
		
		System.out.println(s1.contains(stu2));
		
		s1.close();
	}

}
