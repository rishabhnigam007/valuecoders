package spring_autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		System.out.println("This is come with Autowiring by name");
		ApplicationContext app1=new ClassPathXmlApplicationContext("spring_autowiring/autowiring_by_name.xml");
		
		TextEditor te1=(TextEditor) app1.getBean("textEditor");
		te1.spellCheck();
		System.out.println();
		
		System.out.println("This is come with Autowiring by type");
		ApplicationContext app2=new ClassPathXmlApplicationContext("spring_autowiring/autowiring_by_type.xml");
		
		TextEditor te2=(TextEditor) app2.getBean("textEditor");
		te2.spellCheck();
		System.out.println();
		
		System.out.println("This is come with Autowiring by constructor");
		ApplicationContext app3=new ClassPathXmlApplicationContext("spring_autowiring/autowiring_by_constructor.xml");
		
		TextEditor te3=(TextEditor) app3.getBean("textEditor");
		te3.spellCheck();
		System.out.println();
		
	}
}