package hibernate_native_query_language;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("deprecation")
public class NativeQuery 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
		// Get SessionFactory from HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session from SessionFactory Object
		Session session=sf.openSession();
		
		// Native Queries
		// First write Query for particular class name like here EmployeeDetail and then mapped class using addEntity in which you perform operation
		SQLQuery<EmployeeDetail> query=session.createSQLQuery("select * from EmployeeDetail where age>25");
		query.addEntity(EmployeeDetail.class);
		
		List<EmployeeDetail> list=query.list();
		
		for(EmployeeDetail e:list)
		{
			System.out.println(e);
		}
		
		System.out.println("Print with specific column : ");
		
		query=session.createSQLQuery("select firstName,lastName,salary from EmployeeDetail where salary>22000");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List emp=query.list();
		for(Object o:emp)
		{
			Map m=(Map)o;
			System.out.println(m.get("firstName")+" : "+m.get("lastName")+" : "+m.get("salary"));
		}
		
		
		session.close();
		sf.close();
	}
}

// Main advantage of SQL Native query is we can write directly sql query here with our requirement.


/*

output : 
	
	Hibernate: select * from EmployeeDetail where age>25
	EmployeeDetail [employeeId=23, firstName=anurag, lastName=bajpai, age=26, education=bsc, salary=20000]
	EmployeeDetail [employeeId=24, firstName=rohit, lastName=sharma, age=32, education=polytechnic, salary=22000]
	
	Print with specific column : 
	Hibernate: select firstName,lastName,salary from EmployeeDetail where salary>22000
	rishabh : nigam : 25000
	vikash : singh : 30000
	anuj : verma : 45000
	
*/