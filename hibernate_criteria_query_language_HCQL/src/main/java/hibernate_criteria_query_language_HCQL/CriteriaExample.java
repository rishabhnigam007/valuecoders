package hibernate_criteria_query_language_HCQL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CriteriaExample 
{
	private static void displayEmployeeDetails(EmployeeDetail employee) 
    {
        System.out.println(
                "ID: " + employee.getEmployeeId() + " Age: " + employee.getAge() + " Salary: " + employee.getSalary());
    }
	
	private static void displayEmployeeDetails(List<EmployeeDetail> employeeList) 
	{
        for (EmployeeDetail employee : employeeList) 
        {
            displayEmployeeDetails(employee);
        }
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) 
	{
		// Get SesionFactory Using HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session using SessionFactory Object
		Session session=sf.openSession();
		
		// Create criteria for particular search result
		// Create Criteria for particular class in which you perform operation
		Criteria criteria=session.createCriteria(EmployeeDetail.class);
		
		// Retrieve All EmployeeDetail
		System.out.println("All the EmployeeDetail Retrieved using Criteria");
		displayEmployeeDetails(criteria.list());
		
		// Criterion interface is used for declare criteria for particular search operation
		
		criteria = session.createCriteria(EmployeeDetail.class);
        Criterion employeeIdCriterion = Restrictions.eq("employeeId", 21);
        criteria.add(employeeIdCriterion);
        System.out.println("Employee record whose id is 21");
        displayEmployeeDetails((EmployeeDetail) criteria.uniqueResult());
 
        criteria = session.createCriteria(EmployeeDetail.class);
        Criterion greaterThanCriterion = Restrictions.gt("salary", 25000);
        criteria.add(greaterThanCriterion);
        System.out.println("All the empoyees whose salary is greater than 25000");
        displayEmployeeDetails(criteria.list());
 
        criteria = session.createCriteria(EmployeeDetail.class);
        Criterion greaterThanOrEqualCriterion = Restrictions.ge("salary", 25000);
        criteria.add(greaterThanOrEqualCriterion);
        System.out.println("All the empoyees whose salary is greater than or equal to 25000");
        displayEmployeeDetails(criteria.list());
 
        criteria = session.createCriteria(EmployeeDetail.class);
        Criterion lessThanCriterion = Restrictions.lt("salary", 25000);
        criteria.add(lessThanCriterion);
        System.out.println("All the empoyees whose salary is less than 25000");
        displayEmployeeDetails(criteria.list());
 
        criteria = session.createCriteria(EmployeeDetail.class);
        Criterion lessThanOrEqualCriterion = Restrictions.le("salary", 25000);
        criteria.add(lessThanOrEqualCriterion);
        System.out.println("All the empoyees whose salary is less than or equal to 25000");
        displayEmployeeDetails(criteria.list());
 
        // "Like" example
        List<EmployeeDetail> empList = session.createCriteria(EmployeeDetail.class).add(Restrictions.like("firstName","%o%")).list();
        displayEmployeeDetails(empList);
 
        // Pagination list example
        empList = session.createCriteria(EmployeeDetail.class).addOrder(Order.desc("salary")).setFirstResult(0).setMaxResults(2).list();
        displayEmployeeDetails(empList);
 
        // Combining multiple restrictions
        criteria = session.createCriteria(EmployeeDetail.class);
        Criterion salaryGreaterThan = Restrictions.gt("salary", 25000);
        Criterion ageGreaterThanOrEqual = Restrictions.ge("age", 24);
        Criterion education = Restrictions.in("education", "mca", "bsc");
        LogicalExpression orExp = Restrictions.or(salaryGreaterThan, ageGreaterThanOrEqual);
        criteria.add(orExp);
        criteria.add(education);
        System.out.println("All the empoyees whose salary is greater than 25000 or whose age is greater than 28 and educaton is either MCA or BSc");
        displayEmployeeDetails(criteria.list());
		
		session.close();
		sf.close();
		
	}
}