package hibernate_c3p0_connection_pool;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main 
{
	public static void main(String[] args) 
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		try
		{
			// Create Person Model data
			Person p=new Person();
			p.setName("rishabh");
			p.setCity("kanpur");
			
			session.save(p);
			try
			{
				Thread.sleep(20000);
			}
			catch(InterruptedException ie)
			{
				System.out.println(ie.getMessage());
			}
			t.commit();
			System.out.println("Successfully persisted all the employee records !!");
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			t.rollback();
		}
		finally
		{
			session.close();
			sf.close();
		}
	}
}

/*

hibernate.c3p0.min_size – Minimum number of JDBC connections in the pool.
Hibernate default: 1

hibernate.c3p0.max_size – Maximum number of JDBC connections in the pool.
Hibernate default: 100

hibernate.c3p0.timeout – When an idle connection is removed from the pool (in second).
Hibernate default: 0, never expire.

hibernate.c3p0.max_statements – Number of prepared statements that will be cached.
Hibernate default: 0 , caching is disable.

hibernate.c3p0.idle_test_period – idle time in seconds before a connection is automatically validated.
Hibernate default: 0

*/