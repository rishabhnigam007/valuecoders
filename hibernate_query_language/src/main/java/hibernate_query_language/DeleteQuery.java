package hibernate_query_language;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DeleteQuery 
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
		Query query=session.createQuery("delete from ApplicantBackup where applicantId=:applicantId");
		query.setParameter("applicantId", 19);
		
		int result=query.executeUpdate();
				
		t.commit();
		session.close();
		sf.close();
		System.out.println("No. Of Row Deleted : "+result);
	}
}