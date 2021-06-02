package hibernate_query_language;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PopulateData 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		// Get SessionFactory using HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session from SessionFactory
		Session session=sf.openSession();
		
		// Begin Transaction
		Transaction t=session.beginTransaction();
		
		// Create Applicant Model Data
		ApplicantDetail app1=new ApplicantDetail();
		
		System.out.println("Enter Applicant First Name : ");
		String fname1=sc.next();
		app1.setFirstName(fname1);
		
		System.out.println("Enter Applicant Last Name : ");
		String lname1=sc.next();
		app1.setLastName(lname1);
		
		System.out.println("Enter Applicant Age : ");
		int age1=sc.nextInt();
		app1.setAge(age1);
		
		System.out.println("Enter Applicant Education : ");
		String education1=sc.next();
		app1.setEducation(education1);
		
		session.save(app1);
		
		t.commit();
		sc.close();
		session.close();
		sf.close();
		System.out.println("Successfully Persisted Applicant Details !!");
	}
}