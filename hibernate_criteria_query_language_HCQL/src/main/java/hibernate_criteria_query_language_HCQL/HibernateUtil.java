package hibernate_criteria_query_language_HCQL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	private static SessionFactory buildSessionFactory()
	{
		try
		{
			Configuration con=new Configuration();
			con.configure().addAnnotatedClass(EmployeeDetail.class);
			return (SessionFactory) con.buildSessionFactory();
		}
		catch(Throwable e)
		{
			System.err.println("SessionFactory creation failed.");
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private static final SessionFactory sf=buildSessionFactory();
	
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}
	
	public static void shutdown()
	{
		getSessionFactory().close();
	}
}