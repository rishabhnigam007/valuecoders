package spring_autowiring_java_based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext app=new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		
		HelloWorld hw=app.getBean(HelloWorld.class);
		hw.setMessage("Rishabh Nigam !!");
		hw.getMessage();
		
		System.out.println();
		
		ApplicationContext ctx = 
		         new AnnotationConfigApplicationContext(TextEditorConfig.class);

		TextEditor te = ctx.getBean(TextEditor.class);
		te.spellCheck();
	}
}