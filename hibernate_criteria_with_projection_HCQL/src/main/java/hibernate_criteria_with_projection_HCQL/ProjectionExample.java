package hibernate_criteria_with_projection_HCQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ProjectionExample 
{
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static void main(String[] args) 
	{
		// Get SessionFactory Object  using HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session from SessionFactory Object
		Session session=sf.openSession();
		
		// Create Criteria for projection
		Criteria criteria=session.createCriteria(EmployeeDetail.class);
		
		// Set projection type in which we want to fetch data
		Projection projection=Projections.property("firstName");
		// Set projection on criteria
		criteria.setProjection(projection);
		
		List<String> firstNameList=criteria.list();
		
		System.out.println("All Employee Detail with only First Name  Column : ");
		for(String firstName:firstNameList)
		{
			System.out.println("First Name : "+firstName);
		}
		
		criteria = session.createCriteria(EmployeeDetail.class);
        Projection projection1 = Projections.property("firstName");
        Projection projection2 = Projections.property("salary");
        Projection projection3 = Projections.property("age");
 
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(projection1);
        projectionList.add(projection2);
        projectionList.add(projection3);
 
        criteria.setProjection(projectionList);
 
        List empList = criteria.list();
 
        System.out.println("All the empoyees with first name,salary and age columns");
        Iterator iterator = empList.iterator();
 
        while (iterator.hasNext()) {
            Object[] obj = (Object[]) iterator.next();
            System.out.println("First Name : " + obj[0] + " || Salary : " + obj[1] + " || Age : " + obj[2]);
        }
		
        criteria = session.createCriteria(EmployeeDetail.class);
        criteria.setProjection(Projections.rowCount());
        List<Long> result = criteria.list();
        System.out.println("Total number of employees :" + result);
        
        criteria = session.createCriteria(EmployeeDetail.class);
        double sumSalary = (Long)session.createCriteria(EmployeeDetail.class).setProjection(Projections.sum("salary")).uniqueResult();
        System.out.println("Sum of Salary of all employees : " + sumSalary);
 
        // Adding both restrictions and projection on criteria
        criteria = session.createCriteria(EmployeeDetail.class);
        criteria.add(Restrictions.gt("age", 25));
        criteria.setProjection(projectionList);
        empList = criteria.list();
        Iterator iterator1 = empList.iterator();
        
        System.out.println("All employees whose age is greater than 25");
             
        while (iterator1.hasNext()) 
        {
            Object[] obj = (Object[]) iterator1.next();
            System.out.println("First Name : " + obj[0] + " || Salary : " + obj[1] + " || Age : " + obj[2]);
        }
			
		session.close();
		sf.close();
	}
}


/*

Projections will become handy when we want to load the partial object.

Partial object means only few attributes will be loaded rather than all the attributes.

In some cases, it is unnecessary to load all the attributes of an object.


Main points to remember about Projections : -

Projection is an Interface defined in �org.hibernate.criterion� package
Projections is a class and it is a factory for producing the projection objects.
Projection is mainly used to retrieve partial object.
To add a Projection object to Criteria , we need to call a setProjection() method on Criteria.
We can add as many projection objects as we want but only latest object will be considered, so no use in adding multiple projection objects to criteria.
We need to create one projection object for specifying one property.
If we want more than one property to be included in the result, then we need to create multiple Projection objects one for each property and add all of them to ProjectionList and then we need to set ProjectionList object to Criteria.

*/