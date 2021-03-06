package spring_autowiring_java_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig 
{
	@Bean
	public HelloWorld helloWorld()
	{
		return new HelloWorld();
	}
}


/*
  	This code is equivalent to this bean-----

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<bean id="helloWorld" class="spring_ioc_container.HelloWorld">
		<property name="message"
			value="This message comes from beans value attribute in helloworld.xml bean file" />
	</bean>

</beans>

*/