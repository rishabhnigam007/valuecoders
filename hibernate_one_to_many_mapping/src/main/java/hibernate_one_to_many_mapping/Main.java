package hibernate_one_to_many_mapping;

import java.util.Scanner;

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
       
        session.persist(applicant);
        session.persist(currentAdd);
        session.persist(permanentAdd);
 
        // Commit the transaction and close the session
        t.commit();
        session.close();
        sc.close();
        System.out.println("Successfully Persisted Applicant Details");
    }
}

/*

In this relation mapping, one object of a class is associated with multiple objects of another class.
In other words
One record of a table is associated with multiple records of another table.

In this mapping primary key of One side will become a foreign key in Many side

Example:
Consider Applicant and Address

One Applicant can have have multiple addresses like Permanent address and Current address.

*/

