package com.librarymanagement.library_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    
    
}