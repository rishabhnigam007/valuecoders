package hibernate_aggregate_functions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class AggregateFunctions 
{
	@SuppressWarnings("rawtypes")
	public static void main(String ar[])
	{
		// Get session factory using HibernateUtil class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        // Get session from SessionFactory
        Session session = sf.openSession();
 
        // Retrieve Max (Maximum) salary of Employee
		Query maxSalaryQuery = session.createQuery("select max(salary) FROM EmployeeDetail");
        Object maxSalary = maxSalaryQuery.getSingleResult();
        System.out.println("Maximum salary of Employee -> " + maxSalary);
        System.out.println();
 
        // Retrieve Min (Minimum) salary of Employee
        Query minSalaryQuery = session.createQuery("select min(salary) FROM EmployeeDetail");
        Object minSalary = minSalaryQuery.getSingleResult();
        System.out.println("Minimum salary of Employee -> " + minSalary);
        System.out.println();
 
        // Retrieve Average salary of Employee
        Query avgSalaryQuery = session.createQuery("select avg(salary) FROM EmployeeDetail");
        Object avgSalary = avgSalaryQuery.getSingleResult();
        System.out.println("Average salary of Employees -> " + avgSalary);
        System.out.println();
 
        // Retrieve Number of Employees
        Query empCountQuery = session.createQuery("select count(*) FROM EmployeeDetail");
        Object empCount = empCountQuery.getSingleResult();
        System.out.println("Total number of Employees -> " + empCount);
        System.out.println();
 
        // Retrieve Total Sum of salary of all Employees
        Query sumSalaryQuery = session.createQuery("select sum(salary) FROM EmployeeDetail");
        Object sumSalary = sumSalaryQuery.getSingleResult();
        System.out.println("Total sum of salary of all Employees -> " + sumSalary);
        System.out.println();
 
        session.close();
	}
}