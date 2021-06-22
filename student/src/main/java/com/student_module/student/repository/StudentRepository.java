package com.student_module.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student_module.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	
//	@Query(value = "select s from Student s where s.email = :email")
//	public Student getStudentByStudentName(@Param("email") String email);
	
}