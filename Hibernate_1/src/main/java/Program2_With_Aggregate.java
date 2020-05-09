import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Program2_With_Aggregate {

	public static void main(String[] args) {

		System.out.println("Hibernate Demo 1");

		Configuration conf = new Configuration();
		conf.configure().addAnnotatedClass(Student.class);

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties()).build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session s = sf.openSession();

		Transaction tran = s.beginTransaction();

		// create new student name "hardik"
		Student std1 = new Student();
		std1.studnetName = "hardik";
		std1.standard = "1st";
		std1.mark = 77;
		s.save(std1);

		// create new student name "hardik"
		Student std2 = new Student();
		std2.studnetName = "Viral";
		std2.standard = "1st";
		std2.mark = 99;
		s.save(std2); // to fire insert query

		System.out.println("Student Save : " + std1.studentId);
		tran.commit();
		
		

		// Using Pure/Native SQL
		//s.createQuery("")//HQL
		//s.createSQLQuery("")//Native
		NativeQuery<BigInteger> q1 = s.createSQLQuery("select sum(mark) from STUDENT");
	
		BigInteger q1_Reqeust = q1.getSingleResult();
		//q1.getResultList();
		 	System.out.println(q1_Reqeust);
		 
		
		//select 
		//student0_.studentId as studentI1_0_, student0_.mark as mark2_0_, 
		//student0_.standard as standard3_0_, student0_.stdname as stdname4_0_ 
		//from Student student0_
		Query<Long>  q2 =  s.createQuery("select sum(mark) from Student");
		Long q2_Reqeust = q2.getSingleResult();
		//q1.getResultList();
		 	System.out.println(q2_Reqeust);
		
		/*
		q2.uniqueResult(); //if record not found exception
		q2.uniqueResultOptional(); //if record not found null/[]
		q2.getSingleResult(); //return only one value - sum,Max,Min (mostly use with aggregate function)
		Diff list vs getResultList
		*/
		 
		
		sf.close();

	}

}
