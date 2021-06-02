package hibernate_query_language;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SelectQuery 
{
	public static void main(String[] args) 
	{
		// Get SessionFactory object using HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session From SessionFactory object
		Session session=sf.openSession();
		
		// Starting writing Select Query
		Query query=session.createQuery("FROM ApplicantDetail");
		@SuppressWarnings("unchecked")
		List<ApplicantDetail> list=query.getResultList();
		
		System.out.println("Total Applicant is : "+list.size());
		
		for(ApplicantDetail a:list)
		{
			System.out.print("ID : "+a.getApplicantId());
			System.out.print(" | First Name: "+a.getFirstName());
			System.out.println();
		}
		
		session.close();
		sf.close();
		System.out.println("Successfully Fetch All Record !!");
	}
}