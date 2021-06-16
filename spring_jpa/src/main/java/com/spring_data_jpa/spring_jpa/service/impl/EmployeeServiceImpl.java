package com.spring_data_jpa.spring_jpa.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring_data_jpa.spring_jpa.model.Employee;
import com.spring_data_jpa.spring_jpa.repository.EmployeeRepository;
import com.spring_data_jpa.spring_jpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository er;

	@Override
	public Employee createEmployee(Employee e) 
	{
		return er.save(e);
	}

	@Override
	public void updateEmployee(Employee e) 
	{
		er.saveAndFlush(e);
	}

	@Override
	public void deleteEmployee(int id)
	{
		er.deleteById(id);
	}

	@Override
	public Employee getEmployee(int id)
	{
		Optional<Employee> op=er.findById(id);
		Employee e=op.get();
		return e;
	}

	@Override
	public List<Employee> getEmployee() 
	{
		List<Employee> allEmployee=er.findAll();
		System.out.println("Getting data : "+allEmployee);
		return allEmployee;
	}

	@Override
	public boolean isEmployeeExist(int id) 
	{
		return er.existsById(id);
	}
	
}