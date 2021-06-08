package spring_ioc_container;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class MainApp 
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		//First way to call the bean	
		System.out.println("First message from ApplicationContext calling");
		ApplicationContext app=new ClassPathXmlApplicationContext("spring_ioc_container/helloworld.xml");
		HelloWorld obj1=(HelloWorld)app.getBean("helloWorld");
		obj1.getMessage();
		System.out.println();
		
		//Second way to call the bean
		System.out.println("Second message from XmlBeanFactory calling");
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("spring_ioc_container/helloworld.xml"));
		HelloWorld obj2=(HelloWorld)factory.getBean("helloWorld");
		obj2.getMessage();
		System.out.println();
		
		//Third way to call the bean
		System.out.println("Third message from AbstractApplicationContext calling");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring_ioc_container/helloworld.xml");
		HelloWorld obj3=(HelloWorld) context.getBean("helloWorld");
		obj3.getMessage();
		System.out.println();
		
		//This will ensures a graceful shutdown and calls the relevant destroy methods.
		context.registerShutdownHook();
		
	}
}


/*   
	
	There are mainly two types of IoC container
	1.) BeanFactory
	2.) ApplicationContext
	
    IOC container means inversion of control 
    that mean control spring app through inversion and this inversion, happen with
    inversion class and xml bean file 
    XmlBeanFactory class and ApplicationContext interface that is the class which is used in the 
    conversion and many more class which do this work
    
 */