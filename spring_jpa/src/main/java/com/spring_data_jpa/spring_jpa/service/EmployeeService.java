package com.spring_data_jpa.spring_jpa.service;

import java.util.List;

import com.spring_data_jpa.spring_jpa.model.Employee;

public interface EmployeeService 
{
	public abstract Employee createEmployee(Employee e);
	public abstract void updateEmployee(Employee e);
	public abstract void deleteEmployee(int id);
	public abstract Employee getEmployee(int id);
	public abstract List<Employee> getEmployee();
	public abstract boolean isEmployeeExist(int id);
}