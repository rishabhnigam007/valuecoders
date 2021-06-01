package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeService 
{
	public static void main(String[] args) 
	{
		// set configuration class
		Configuration con=new Configuration();
		con.configure().addAnnotatedClass(Employee.class);
		
		// create sessionfactory object
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
					System.out.println("1. Fetch By Id : ");
					System.out.println("2. Fetch All : ");
					System.out.println("Enter choice : ");
					int c=sc.nextInt();
					switch(c)
					{
						case 1:
								try {
								System.out.println("Enter id :");
								int id1=sc.nextInt();
								
								Employee ef=null;
								
								// load return the proxy object 
								// also use get() method
								ef=session.load(Employee.class, id1);
								
								System.out.println("======================");
								System.out.println("ID : "+ef.getId());
								System.out.println("First Name : "+ef.getFname());
								System.out.println("Last Name : "+ef.getLname());
								System.out.println("======================");
								}
								catch (Exception e2)
								{
									System.err.println("Invalid Id Entered !! ");
								}
								break;
								
						case 2:
								List<Employee> employeelist=new ArrayList<Employee>();
								employeelist=session.createQuery("FROM Employee").list();
								if(employeelist != null & employeelist.size() > 0) 
								{
									Iterator<Employee> itr=employeelist.iterator();
									while(itr.hasNext())
									{
										System.out.println(itr.next());
									}
								}						        
								break;
								
						default:
								System.out.println("Invalid Choice !!");
								System.exit(0);
					}
								
					break;
					
			case 3:
					System.out.println("Enter id for data updation : ");
					int id=sc.nextInt();
					e=session.get(Employee.class, id);
					
					System.out.println("Enter First Name : ");
					String fname1=sc.next();
					
					System.out.println("Enter Last Name : ");
					String lname1=sc.next();
					
					e.setFname(fname1);
					e.setLname(lname1);
					
					Transaction t1=session.beginTransaction();
					session.update(e);
					
					if(session != null)
					{
						System.out.println("Record updated successfully !!");
						t1.commit();
					}		
					
					break;
					
			case 4:
					System.out.println("1. Delete By Id : ");
					System.out.println("2. Delete All : ");
					System.out.println("Enter choice : ");
					int ch=sc.nextInt();
					switch(ch)
					{
						case 1:
							try 
							{
								System.out.println("Enter id for deletion : ");
								int id2=sc.nextInt();
								e=session.load(Employee.class, id2);
								
								Transaction t2=session.beginTransaction();
								session.delete(e);
								if(session != null)
								{
									System.out.println("Record deleted successfully !!");
									t2.commit();
								}
							}
							catch (Exception e2)
							{
								System.err.println("Invalid Id Entered !! ");
							}
							break;
							
					case 2:
							try 
							{
								Transaction t2=session.beginTransaction();
								Query obj=session.createQuery("DELETE FROM Employee");
								obj.executeUpdate();			
								if(session != null)
								{
									System.out.println("All Record deleted successfully !!");
									t2.commit();
								}
							}
							catch(Exception e3)
							{
								System.err.println("Some Error occur !!"+e3.getMessage());
							}
							
							break;
							
					default:
							System.out.println("Invalid Choice !!");
							System.exit(0);
				}
					
				break;

			default:
					System.out.println("Invalid choice !!");
					System.exit(0);
		}
		
		sc.close();
		session.close();
		sf.close();
	}
}