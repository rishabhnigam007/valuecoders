package com.librarymanagement.library_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagement.library_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
