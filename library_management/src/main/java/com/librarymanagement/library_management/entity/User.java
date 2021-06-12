package com.librarymanagement.library_management.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull(message = "Name field should not blank")
    @NotBlank(message = "Name field is required !!")
    @Size(min = 2, max = 20 , message = "Name should be between 2 - 20 characters !!")
    private String name;
    
    @Column(unique = true)
    @NotBlank(message = "Email field is required !!")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    
    @NotBlank(message = "Password field is required !!")
    @Size(min = 2, message = "Password should be atleast 2 characters !!")
    private String password;
    
    private String role;
//    @AssertTrue(message = "Must agree terms and condition !!")
    private boolean enabled;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<Book> books=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public User(int id,
			@NotNull(message = "Name field should not blank") @NotBlank(message = "Name field is required !!") @Size(min = 2, max = 20, message = "Name should be between 2 - 20 characters !!") String name,
			@NotBlank(message = "Email field is required !!") @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") String email,
			@NotBlank(message = "Password field is required !!") @Size(min = 2, message = "Password should be atleast 2 characters !!") String password,
			String role, boolean enabled, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.books = books;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + ", books=" + books + "]";
	} 
	
}