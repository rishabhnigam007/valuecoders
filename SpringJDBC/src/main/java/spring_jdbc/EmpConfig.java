package spring_jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("application.properties")
public class EmpConfig 
{
	@Bean(name = "emp")
	public Emp emp() 
	{
		return new Emp();
	}

	@Bean(name = "edao")
	public EmpDao edao() 
	{
		return new EmpDao();
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate(DataSource dataSource) 
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
	
	// This is direct connectivity with assigning values
	
//	@Bean
//	public DataSource dataSource() 
//	{
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/test1");
//		dataSource.setUsername("root");
//		dataSource.setPassword("1234");
//		return dataSource;
//	}
	
	// This is using property file setting with the help of environment but in this simple jdbc convention follow 
	
//	@Bean
//	public DataSource dataSource()
//	{
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
//		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
//		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
//		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
//		return dataSource;
//	}
	
	@Autowired
	private Environment env;
	
	// This is used spring file property for doing this
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}
	
}