package hibernate_aggregate_functions;

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
		EmployeeDetail e1=new EmployeeDetail();
		
		System.out.println("Enter Employee 1 Detail : ");
		
		System.out.println("Enter Applicant First Name : ");
		String fname1=sc.next();
		e1.setFirstName(fname1);
		
		System.out.println("Enter Applicant Last Name : ");
		String lname1=sc.next();
		e1.setLastName(lname1);
		
		System.out.println("Enter Applicant Age : ");
		int age1=sc.nextInt();
		e1.setAge(age1);
		
		System.out.println("Enter Applicant Education : ");
		String education1=sc.next();
		e1.setEducation(education1);
		
		System.out.println("Enter Applicant Salary : ");
		int salary1=sc.nextInt();
		e1.setSalary(salary1);
		
		EmployeeDetail e2=new EmployeeDetail();
		
		System.out.println("Enter Employee 2 Detail : ");
		
		System.out.println("Enter Applicant First Name : ");
		String fname2=sc.next();
		e2.setFirstName(fname2);
		
		System.out.println("Enter Applicant Last Name : ");
		String lname2=sc.next();
		e2.setLastName(lname2);
		
		System.out.println("Enter Applicant Age : ");
		int age2=sc.nextInt();
		e2.setAge(age2);
		
		System.out.println("Enter Applicant Education : ");
		String education2=sc.next();
		e2.setEducation(education2);
		
		System.out.println("Enter Applicant Salary : ");
		int salary2=sc.nextInt();
		e2.setSalary(salary2);
		
		EmployeeDetail e3=new EmployeeDetail();
		
		System.out.println("Enter Employee 3 Detail : ");
				
		System.out.println("Enter Applicant First Name : ");
		String fname3=sc.next();
		e3.setFirstName(fname3);
				
		System.out.println("Enter Applicant Last Name : ");
		String lname3=sc.next();
		e3.setLastName(lname3);
				
		System.out.println("Enter Applicant Age : ");
		int age3=sc.nextInt();
		e3.setAge(age3);

		System.out.println("Enter Applicant Education : ");
		String education3=sc.next();
		e3.setEducation(education3);
		
		System.out.println("Enter Applicant Salary : ");
		int salary3=sc.nextInt();
		e3.setSalary(salary3);
		
		EmployeeDetail e4=new EmployeeDetail();
		
		System.out.println("Enter Employee 4 Detail : ");
				
		System.out.println("Enter Applicant First Name : ");
		String fname4=sc.next();
		e4.setFirstName(fname4);
				
		System.out.println("Enter Applicant Last Name : ");
		String lname4=sc.next();
		e4.setLastName(lname4);
				
		System.out.println("Enter Applicant Age : ");
		int age4=sc.nextInt();
		e4.setAge(age4);

		System.out.println("Enter Applicant Education : ");
		String education4=sc.next();
		e4.setEducation(education4);
		
		System.out.println("Enter Applicant Salary : ");
		int salary4=sc.nextInt();
		e4.setSalary(salary4);
		
		EmployeeDetail e5=new EmployeeDetail();
		
		System.out.println("Enter Employee 5 Detail : ");
				
		System.out.println("Enter Applicant First Name : ");
		String fname5=sc.next();
		e5.setFirstName(fname5);
				
		System.out.println("Enter Applicant Last Name : ");
		String lname5=sc.next();
		e5.setLastName(lname5);
				
		System.out.println("Enter Applicant Age : ");
		int age5=sc.nextInt();
		e5.setAge(age5);

		System.out.println("Enter Applicant Education : ");
		String education5=sc.next();
		e5.setEducation(education5);
		
		System.out.println("Enter Applicant Salary : ");
		int salary5=sc.nextInt();
		e5.setSalary(salary5);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		
		t.commit();
		sc.close();
		session.close();
		sf.close();
		System.out.println("Successfully Persisted EmployeeDetails !!");
	}
}