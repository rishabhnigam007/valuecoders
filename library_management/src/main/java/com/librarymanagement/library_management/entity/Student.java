package com.librarymanagement.library_management.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Student")
public class Student 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    
    @NotNull(message = "Student name should not blank")
    @NotBlank(message = "Student name is required !!")
    @Size(min = 2, max = 20 , message = "Student name should be between 2 - 20 characters !!")
    private String sname;
    
    @Column(unique = true)
    @NotBlank(message = "Email is required !!")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    
    @NotNull(message = "Standard should not blank")
    @NotBlank(message = "Standard is required !!")
    @Size(min = 2, max = 20 , message = "Student name should be between 2 - 20 characters !!")
    private String standard;
    
//    @ManyToMany(targetEntity = Book.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @ManyToMany(targetEntity = Book.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(joinColumns = {@JoinColumn(name = "sid")},inverseJoinColumns = {@JoinColumn(name="b_id")})
    @JsonIgnore
    //bydefault mapping it create this by using column names
    private List<Book> books=new ArrayList<>();
    
    

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + ", standard=" + standard + "]";
	}
    
    
}