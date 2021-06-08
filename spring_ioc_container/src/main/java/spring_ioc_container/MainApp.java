package spring_ioc_container;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class MainApp 
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		//First way to call the bean
			
		ApplicationContext app=new ClassPathXmlApplicationContext("helloworld.xml");
		HelloWorld obj=(HelloWorld)app.getBean("helloWorld");
		obj.getMessage();
		
		//Second way to call the bean
		System.out.println("Second message from xmlfactory calling");
		
		
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("helloworld.xml"));
		HelloWorld obj1=(HelloWorld)factory.getBean("helloWorld");
		obj1.getMessage();
	}
}


/*   
    IOC container means inversion of control 
    that mean control spring app through inversion and this inversion happen with
    inversion class and xml bean file 
    XmlBeanFactory class and ApplicationContext interface that is the class which is used in the 
    conversion and many more class which do this work
    
 */