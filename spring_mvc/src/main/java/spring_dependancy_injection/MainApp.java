package spring_dependancy_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext app=new ClassPathXmlApplicationContext("spring_dependancy_injection/dependancy_injection.xml");
		
		TextEditor te=(TextEditor) app.getBean("textEditor");
		te.spellCheck();
	}
}

/*
 	Dependency Injection or sometime it say autowiring 
 	for injecting one class property to another class
 	we use dependency injection in spring boot we use @Autowire annotation for doing this work. 		
*/