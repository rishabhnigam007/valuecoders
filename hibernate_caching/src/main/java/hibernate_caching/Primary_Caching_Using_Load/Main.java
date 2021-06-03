package hibernate_caching.Primary_Caching_Using_Load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main 
{
	public static void main(String[] args) 
	{		
		// Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
       
        // Get session from Session factory
        Session session = sf.openSession();
 
        // Load the Person details whose Id is 32
        Person p = (Person) session.load(Person.class, new Integer(32));
        displayPersonDetails(p);
 
        // Load the same Person again with new Session
        p = (Person) session.load(Person.class, new Integer(32));
        displayPersonDetails(p);
        
        session.close();
	}

	private static void displayPersonDetails(Person p) 
	{
		System.out.println("ID : "+p.getId()+" Name : "+p.getName()+" City : "+p.getCity());	
	}
}