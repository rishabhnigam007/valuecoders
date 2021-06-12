package com.librarymanagement.library_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librarymanagement.library_management.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{
	// search
//	public List<Book> findByNameContainingAndUser(String name,User user);
}