package com.librarymanagement.library_management.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.librarymanagement.library_management.dao.BookRepository;
import com.librarymanagement.library_management.dao.UserRepository;
import com.librarymanagement.library_management.entity.Book;
import com.librarymanagement.library_management.entity.User;
import com.librarymanagement.library_management.helper.Message;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// method for all common response
	@ModelAttribute
	public void addCommonData(Model model,Principal principle)
	{
		String userName=principle.getName();
		System.out.println("USERNAME "+userName);
		
		User user=userRepository.getUserByUserName(userName);
		System.out.println("USER "+user);
		
		model.addAttribute("user", user);
	}
	
	@RequestMapping(value = "/index" ,method = RequestMethod.GET)
	public String dashboard(Model model,Principal principal)
	{
		model.addAttribute("title", "Librarian DashBoard");
		return "normal/librarian_dashboard";
	}
	
	@GetMapping("/add-book")
	public String openAddBookForm(Model model)
	{
		model.addAttribute("title", "Add Book");
		model.addAttribute("book", new Book());
		
		return "normal/add_book_form";
	}
	
	@PostMapping("/process-book")
	public String processBook(@ModelAttribute Book book,Principal principal,HttpSession session,Model model)
	{
		try
		{
			String name=principal.getName();
			User user=this.userRepository.getUserByUserName(name);
			
			book.setUser(user);
			user.getBooks().add(book);
			this.userRepository.save(user);
			System.out.println("Data "+book);
			System.out.println("Added to database");
			
			session.setAttribute("message", new Message("Your Book is added !! add more", "success"));
		}
		catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
			
			session.setAttribute("message", new Message("Something went wrong !!", "danger"));
		}
		
		model.addAttribute("title", "Your Book Added !!");
		return "normal/add_book_form";		
	}
	
	@GetMapping("/{bId}/book")
	public String showBookDetail(@PathVariable("bId") Integer bId, Model model,Principal principal)
	{
		System.out.println("BID "+bId);
		try
		{
			Optional<Book> bookOptional=this.bookRepository.findById(bId);
			Book book=bookOptional.get();
			System.out.println(book.toString());
			
			String userName=principal.getName();
			User user=this.userRepository.getUserByUserName(userName);
			
			if(user.getId()==book.getUser().getId())
			{
				model.addAttribute("book", book);
			}
			model.addAttribute("title", "Your Book : "+book.getBookName());
		}
		catch(Exception e)
		{
			model.addAttribute("title", "Book Not Found");
			return "normal/book_not_found";
		}
		return "normal/book_detail";
	}
	
	
	
}