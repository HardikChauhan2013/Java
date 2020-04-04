import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class Program {

	public static void main(String[] args) {

		System.out.println("Hibernate Demo 1");
		
		Configuration conf  = new Configuration();
		conf.configure().addAnnotatedClass(Student.class);
		
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties())
				.build();
		
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		
		
		Session s  = sf.openSession();
		
		Transaction tran = s.beginTransaction();
		
		Student std1 = new Student();
		std1.studnetName="hardik";
		std1.standard="1st";
		std1.mark=99;
		s.save(std1);
 		 
		System.out.println("Student Save : " + std1.studentId);
		tran.commit();
		  
		//Using Pure SQL
		NativeQuery<Student> q1 = s.createSQLQuery("select * from STUDENT");
		q1.addEntity(Student.class);

		List<Student> q1_Reqeust =  q1.list(); 
		for (Student student : q1_Reqeust) {
			System.out.println(student.studnetName);
		}
		
		
		
		sf.close();

	}

}
