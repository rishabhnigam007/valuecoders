package hibernate_caching.Secondary_Level_Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate_caching.Primary_Caching_Using_Load.HibernateUtil;
import hibernate_caching.Primary_Caching_Using_Load.Person;

public class SecondaryCacheDemo 
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
 
        // Create a new Session
        Session session1 = sf.openSession();
        
        // Load the same Person again with new Session
        p=(Person) session1.load(Person.class, 32);
        displayPersonDetails(p);
                
        session.close();
        session1.close();
	}

	private static void displayPersonDetails(Person p) 
	{
		System.out.println("ID : "+p.getId()+" Name : "+p.getName()+" City : "+p.getCity());	
	}
}

// For enable query cache write - query_obj.setCacheable(true)