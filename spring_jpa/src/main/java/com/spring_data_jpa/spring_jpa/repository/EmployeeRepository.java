package com.spring_data_jpa.spring_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_data_jpa.spring_jpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

}