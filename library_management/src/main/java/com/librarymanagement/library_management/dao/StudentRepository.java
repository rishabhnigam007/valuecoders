package com.librarymanagement.library_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librarymanagement.library_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	
//	@Query(value = "select s from Student s where s.email = :email")
//	public Student getStudentByStudentName(@Param("email") String email);
	
}