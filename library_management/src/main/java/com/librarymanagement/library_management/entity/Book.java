package com.librarymanagement.library_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Book")
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	
	@NotBlank(message = "Book Title is required !!")
    @Size(min = 2, max = 20 , message = "Book Title should be between 2 - 20 characters !!")
	private String bookTitle;
	
	@NotBlank(message = "Book Name is required !!")
    @Size(min = 2, max = 20 , message = "Book Name should be between 2 - 20 characters !!")
	private String bookName;

	@Column(length = 1600)
//	@NotBlank(message = "Description field is required !!")
	private String description;
	
	@ManyToOne
	@JsonIgnore
	private User user;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		return this.bId==((Book) obj).getbId();
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bookTitle=" + bookTitle + ", bookName=" + bookName + ", description="
				+ description + "]";
	}	
		
}