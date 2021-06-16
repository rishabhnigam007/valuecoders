package com.librarymanagement.library_management.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.librarymanagement.library_management.dao.StudentRepository;
import com.librarymanagement.library_management.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/register")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student e) throws Exception
	{
		e=studentRepository.save(e);
		return new ResponseEntity<Object>("Student is created successfully "+e.getSid(),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateStudent(@Valid @PathVariable("id") int id,@Valid @RequestBody Student e)
	{
		boolean isexist=studentRepository.existsById(id);
		if(isexist)
		{
			e.setSid(id);
			studentRepository.saveAndFlush(e);
			return new ResponseEntity<Object>("Student is updated successfully "+e.getSid(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>("Student not found ",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteStudent(@Valid @PathVariable("id") int id) throws Exception
	{
		boolean isexist=studentRepository.existsById(id);
		if(isexist)
		{
			studentRepository.deleteById(id);;
			return new ResponseEntity<Object>("Student Deleted successfully with ID : "+id,HttpStatus.GONE);
		}
		else
		{
			return new ResponseEntity<Object>("Student not found ",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/studentbyid/{id}")
	public ResponseEntity<Object> getStudentById(@Valid @PathVariable("id") int id) 
	{
		boolean isexist=studentRepository.existsById(id);
		if(isexist)
		{
			Student e=studentRepository.getById(id);
			return new ResponseEntity<Object>("Student : "+e.toString(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>("Student not found ",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allstudent")
	public ResponseEntity<Object> getAllStudent()
	{
		List<Student> list=studentRepository.findAll();	
		return new ResponseEntity<Object>(list.toString(),HttpStatus.OK);
	}
}