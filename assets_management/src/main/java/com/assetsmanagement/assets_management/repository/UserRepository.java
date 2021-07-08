package com.assetsmanagement.assets_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assetsmanagement.assets_management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select u from User u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);
	
	@Query(value = "select u from User u where u.role = 'ROLE_USER'")
	public List<User> listAll();
}