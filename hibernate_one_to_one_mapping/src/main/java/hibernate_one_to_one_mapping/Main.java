package hibernate_one_to_one_mapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main 
{
	public static void main(String[] args) throws ParseException 
	{
		Scanner sc=new Scanner(System.in);
		
		// Get SessionFactory using HibernateUtil class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session from SesionFactory
		Session s=sf.openSession();
		
		// Begin Transaction
		Transaction t=s.beginTransaction();
		
		// create Applicant model data
		Applicant a=new Applicant();
		
		System.out.println("Enter Apllicant Name : ");
		String name=sc.next();
		
		System.out.println("Enter Applicant Age : ");
		int age=sc.nextInt();
		
		System.out.println("Enter Applicant City : ");
		String city=sc.next();
		
		a.setName(name);
		a.setAge(age);
		a.setCity(city);
		
		s.save(a);
		
		// create Passport model data
		Passport p=new Passport();
		
		System.out.println("Enter Passport Number : ");
		String pno=sc.next();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enter Date with ths format : 2021-06-15 ");
		System.out.println("Enter Issued Date : ");
//		String Issuedate = sc.nextLine();
//	    Date issued=new SimpleDateFormat("YYYY-MM-dd").parse(Issuedate);
	    
		String Issuedate=sc.next();
		Date issued=sdf1.parse(Issuedate);
		sdf1=new SimpleDateFormat("yyyy-MM-dd");
		sdf1.format(issued);
		
	    // 2020-08-31 this is in sql databse format
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enter Date with ths format : 2021-06-15 ");
		System.out.println("Enter Expiry Date : ");
//		String Expirydate = sc.nextLine();
//	    Date expiry=new SimpleDateFormat("YYYY-MM-dd").parse(Expirydate);
		
		String Expirydate=sc.next();
		Date expiry=sdf2.parse(Expirydate);
		sdf2=new SimpleDateFormat("yyyy-MM-dd");
		sdf2.format(expiry);
		
		p.setPassportNumber(pno);
		p.setIssuedDate(issued);
		p.setExpiryDate(expiry);
				
		// mapping and setting 
		a.setPassport(p);
		p.setApplicant(a);
		s.persist(a);
		
		// commit changes and save to the database.
		t.commit();
		s.close();
		sc.close();
		System.out.println("Successfully Save Applicant Details !!");
	}
}