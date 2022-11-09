package com.codersathi.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codersathi.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// Select * from user where username = ?
	User findByUsername(String username);

}
