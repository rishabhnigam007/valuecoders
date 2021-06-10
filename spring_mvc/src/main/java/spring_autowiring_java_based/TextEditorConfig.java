package spring_autowiring_java_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextEditorConfig 
{
	@Bean
	public TextEditor textEditor()
	{
		return new TextEditor(spellChecker());
	}

	@Bean
	public SpellChecker spellChecker() 
	{
		return new SpellChecker();
	}
}


/*
 	
 	This class code is equivalent to this xml bean file -----
 	
 <?xml version="1.0" encoding="UTF-8"?>

<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean -->
   <bean id = "textEditor" class = "spring_dependancy_injection.TextEditor">
      <constructor-arg ref = "spellChecker"/>
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id = "spellChecker" class = "spring_dependancy_injection.SpellChecker"></bean>

</beans>
 	
 */