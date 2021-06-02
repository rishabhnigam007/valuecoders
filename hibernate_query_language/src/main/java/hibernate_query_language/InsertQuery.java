package hibernate_query_language;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class InsertQuery 
{
	public static void main(String[] args) 
	{
		// Get SessionFactory object from HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session from SessionFactory object
		Session session=sf.openSession();
		
		// Begin Transaction
		Transaction t=session.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("insert into ApplicantBackup ( applicantId, firstName, lastName, age, education ) select  applicantId, firstName, lastName, age, education from ApplicantDetail ");
		
		int result=query.executeUpdate();
		
		t.commit();
		session.close();
		sf.close();
		System.out.println("No. Of Row Inserted : "+result);
	}
}