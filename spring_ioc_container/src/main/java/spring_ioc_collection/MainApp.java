package spring_ioc_collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext app=new ClassPathXmlApplicationContext("spring_ioc_collection/javacollection.xml");
		JavaCollection jc=(JavaCollection) app.getBean("javaCollection");
		
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	}
}