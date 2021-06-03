package hibernate_cascading_strategy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		 // Get session factory using Hibernate Util class
		SessionFactory sf = HibernateUtil.getSessionFactory();
       
       // Get session from Session factory
       Session session = sf.openSession();

       // Begin transaction
       Transaction t = session.beginTransaction();
      
       //Create ApplicantDetail Model data
       ApplicantDetail applicant = new ApplicantDetail();
       
       
       System.out.println("Enter Applicant First Name : ");
       String fname=sc.next();
       applicant.setFirstName(fname);
       
       System.out.println("Enter Applicant Last Name : ");
       String lname=sc.next();
       applicant.setLastName(lname);
       
       System.out.println("Enter Applicant Age : ");
       int age=sc.nextInt();
       applicant.setAge(age);
       
       System.out.println("Enter Applicant Education : ");
       String education=sc.next();
       applicant.setEducation(education);

       //Create Address Model data
       Address currentAdd = new Address();
       
       System.out.println("Please Enter Current Address : -----");
       
       System.out.println("Enter Street : ");
       String street=sc.next();
       currentAdd.setStreet(street);
       
       System.out.println("Enter City : ");
       String city=sc.next();
       currentAdd.setCity(city);
       
       System.out.println("Enter Pincode : ");
       String pincode=sc.next();
       currentAdd.setZipcode(pincode);
      
       //Associate Applicant to  current Address
       currentAdd.setApplicant(applicant);
      
       System.out.println("Please Enter Permanent Address : -----");
       
       Address permanentAdd = new Address();
       
       System.out.println("Enter Street : ");
       String pstreet=sc.next();
       permanentAdd.setStreet(pstreet);
       
       System.out.println("Enter City : ");
       String pcity=sc.next();
       permanentAdd.setCity(pcity);
       
       System.out.println("Enter Pincode : ");
       String pincode1=sc.next();
       permanentAdd.setZipcode(pincode1);
      
       //Associate Applicant to permanent Address
       permanentAdd.setApplicant(applicant);
       
       Set<Address> addresses = new HashSet<Address>();
       addresses.add(currentAdd);
       addresses.add(permanentAdd);

       applicant.setAddresses(addresses);
      
       session.save(applicant);

       // Commit the transaction and close the session
       t.commit();
       session.close();
       sf.close();
       sc.close();
       System.out.println("Successfully Persisted Applicant Details");
	}
}