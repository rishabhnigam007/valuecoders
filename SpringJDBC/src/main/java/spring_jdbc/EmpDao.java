package spring_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveEmployee(Emp e)
	{
		String query="insert into emp values(' "+e.getId()+" ' , ' "+e.getName()+" ' , ' "+e.getAge()+" ')";
		return jdbcTemplate.update(query);
	}
	
	public int updateEmployee(Emp e)
	{
		String query="update emp set name = ' "+e.getName()+" ' , age = ' "+e.getAge()+" ' where id = ' "+e.getId()+" ' ";
		return jdbcTemplate.update(query);
	}
	
	public int deleteEmployee(int id)
	{
		String query="delete from emp where id='"+id+"'";
		return jdbcTemplate.update(query);
	}
	
}