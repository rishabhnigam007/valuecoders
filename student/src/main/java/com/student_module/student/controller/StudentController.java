package com.student_module.student.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.student_module.student.helper.Message;
import com.student_module.student.repository.StudentRepository;
import com.student_module.student.entity.Student;

@Controller
public class StudentController 
{
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "Home - Student Registration");
		return "home";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title", "Student Registeration Page");
		model.addAttribute("student",new Student());
		return "signup";
	}
	
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("student") Student student,BindingResult result1,Model model,HttpSession session)
	{
		// if Binding result is declare in the last after http session then changes not reflected in page so paste it in after user model attribute
		try 
		{
			if(result1.hasErrors())
			{
				System.out.println("Error "+result1.toString());
				model.addAttribute("student", student);
				return "signup";
			}
			
			System.out.println("Student "+student);
			studentRepository.save(student);
			//new student() for when register and hit submit button then form clean and ready for again register.
			model.addAttribute("student", new Student());
			session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			return "signup";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("student",student);
			session.setAttribute("message", new  Message("Something went wrong !! "+e.getMessage(), "alert-danger"));
			return "signup";
		}	
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public String DeleteStudent()
	{
		this.studentRepository.deleteAll();
 		return "All Student Deleted Successfully !!";
	}
	
}