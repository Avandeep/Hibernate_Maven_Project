package com.hibernate.map.m2o_o2m;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SessionFactory factory = new Configuration().configure("/com/hibernate/map/m2o_o2m/hibernate.cfg.xml").buildSessionFactory();
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Question_m2o_o2m q1 = new Question_m2o_o2m();
		q1.setQuestionId(111);
		q1.setQuestion("java ?");
		

		Answer_m2o_o2m a1 = new Answer_m2o_o2m();
		a1.setAnswerId(112);
		a1.setAnswer("Programming Language");
		
		Answer_m2o_o2m a2 = new Answer_m2o_o2m();
		a2.setAnswerId(113);
		a2.setAnswer("Used to build software applications");
		
		Answer_m2o_o2m a3 = new Answer_m2o_o2m();
		a3.setAnswerId(114);
		a3.setAnswer("has oops concepts");
		
		List<Answer_m2o_o2m> list=new ArrayList<Answer_m2o_o2m>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		a1.setQuestion(q1);
		a2.setQuestion(q1);
		a3.setQuestion(q1);
		

		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
	session.save(q1);
	session.save(a1);
	session.save(a2);
	session.save(a3);
		
		tx.commit();
		
		Question_m2o_o2m ques=session.get(Question_m2o_o2m.class, 111);
		System.out.println(ques.getQuestion());
		
		for(Answer_m2o_o2m ans:ques.getAnswers())
		{
			System.out.println(ans.getAnswer());
		//	System.out.println(ans.getQuestion().getQuestion());
			
		}
		
	//	Answer ans=session.get(Answer.class, 112);
	//	System.out.println(ans.getQuestion().getQuestion());
		
		
		session.close();
		
		factory.close();
	}

}
