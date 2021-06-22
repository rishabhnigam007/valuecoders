package com.spring_data_jpa.spring_jpa;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring_data_jpa.spring_jpa.model.Employee;
import com.spring_data_jpa.spring_jpa.repository.EmployeeRepository;
import com.spring_data_jpa.spring_jpa.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJpaApplicationTests 
{
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public void saveEmployeeTest()
	{
		Employee emp=new Employee(7, "happu", 45, 45000);
		when(repository.save(emp)).thenReturn(emp);
		assertEquals(emp, service.createEmployee(emp));
	}
	
	@Test
	public void deleteEmployeeTest(int id)
	{
		//Employee emp=new Employee(7, "happu", 45, 45000);
		Employee emp=repository.getById(id);
		service.deleteEmployee(emp.getId());
		verify(repository,times(1)).deleteById(emp.getId());
	}

	@Test
	public void getEmployeeTest()
	{
		when(repository.findAll())
		.thenReturn(Stream.of(new Employee(6,"abc",23,4579.0)
				,new Employee(7, "pqr", 25, 35676.8)).collect(Collectors.toList()));
		assertEquals(2, service.getEmployee().size());
	}

}
