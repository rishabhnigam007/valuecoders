package spring_jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbc 
{
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		ApplicationContext app=new AnnotationConfigApplicationContext(EmpConfig.class);
		
		EmpDao dao=(EmpDao) app.getBean("edao",EmpDao.class);
		
		int create=dao.saveEmployee(new Emp(3,"happu",45));
		if(create>0)
		{
			System.out.println("Successfully inserted!!");
		}
		else
		{
			System.out.println("Not inserted !!");
		}
		
		EmpDao dao1=(EmpDao) app.getBean("edao",EmpDao.class);
		
		int update=dao1.updateEmployee(new Emp(2,"rishabh",24));
		if(update>0)
		{
			System.out.println("Successfully updated record !!");
		}
		else
		{
			System.out.println("Not updated !!");
		}
		
		EmpDao dao2=(EmpDao) app.getBean("edao",EmpDao.class);
		
		int delete=dao2.deleteEmployee(3);
		if(delete>0)
		{
			System.out.println("Successfully deleted !!");
		}
		else
		{
			System.out.println("Not deleted !!");
		}
		
	}
}

/*
 * To use this spring-jdbc we must add spring-jdbc dependency then only you can
 * use.
 */