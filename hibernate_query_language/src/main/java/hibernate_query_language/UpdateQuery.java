package hibernate_query_language;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UpdateQuery 
{
	public static void main(String[] args) 
	{
		// Get SessionFactory using HibenateUtil class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session from SessionFactory
		Session session=sf.openSession();
		
		// Begin Transaction
		Transaction t=session.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("update ApplicantDetail set age=:age where applicantId=:applicantId");
		query.setParameter("age", 30);
		query.setParameter("applicantId", 18);
		
		int result = query.executeUpdate();
		
		t.commit();
		session.close();
		sf.close();
		System.out.println("No of rows updated : "+result);
	}
}