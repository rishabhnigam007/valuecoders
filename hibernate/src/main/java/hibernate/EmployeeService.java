package hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeService 
{
	public static void main(String[] args) 
	{
		// set configuration
		Configuration con=new Configuration();
		con.configure().addAnnotatedClass(Employee.class);
		
		// create session factory object
		SessionFactory sf=con.buildSessionFactory();
		
		// create session object for communicating database
		Session session=sf.openSession();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(" 1. Insert data : (Create Operation) ");
		System.out.println(" 2. Fetch data : (Read Operation) ");
		System.out.println(" 3. Update data : (Update Operation) ");
		System.out.println(" 4. Delete data : (Delete Operation) ");
		System.out.println("Enter choice : ");
		int choice = sc.nextInt();
		System.out.println();
		Employee e=new Employee();
		switch (choice)
		{
			case 1:
					System.out.println("Enter First Name : ");
					String fname=sc.next();
					
					System.out.println("Enter Last Name : ");
					String lname=sc.next();
					
					e.setFname(fname);
					e.setLname(lname);
					
					Transaction t=session.beginTransaction();
					session.save(e);
					
					if(session != null)
					{
						System.out.println("Record inserted successfully !!");
						t.commit();
					}					
					break;
				
			case 2:
					System.out.println("Enter id :");
					int id1=sc.nextInt();
					e=(Employee)session.get(Employee.class, id1);
					System.out.println(e);
					break;
					
			case 3:
					System.out.println("Enter id for data updation : ");
					int id=sc.nextInt();
					e=(Employee)session.get(Employee.class, id);
					
					System.out.println("Enter First Name : ");
					String fname1=sc.next();
					
					System.out.println("Enter Last Name : ");
					String lname1=sc.next();
					
					e.setFname(fname1);
					e.setLname(lname1);
					
					Transaction t1=session.beginTransaction();
					session.save(e);
					
					if(session != null)
					{
						System.out.println("Record updated successfully !!");
						t1.commit();
					}		
					
					break;
					
			case 4:
					System.out.println("Enter id for deletion : ");
					int id2=sc.nextInt();
					e=(Employee)session.get(Employee.class, id2);
					
					Transaction t2=session.beginTransaction();
					session.delete(e);
					
					if(session != null)
					{
						System.out.println("Record deleted successfully !!");
						t2.commit();
					}
					
					break;

			default:
					System.out.println("Invalid choice !!");
					System.exit(0);
		}
		
		sc.close();
		session.close();
	}
}