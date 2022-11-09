package com.codersathi.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codersathi.userservice.dto.LoginRequestDto;
import com.codersathi.userservice.dto.LogoutRequestDto;
import com.codersathi.userservice.dto.UserCreateDto;
import com.codersathi.userservice.dto.UserResponseDto;
import com.codersathi.userservice.entity.User;
import com.codersathi.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createUser(@RequestBody UserCreateDto user) {
		userService.createUser(user);
		return "Success!";
	}

	@GetMapping("/{userId}")
	public UserResponseDto getUser(@PathVariable("userId") Long id) {
		System.out.println("User ID " + id);
		return userService.getUser(id);
	}

	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {

		return userService.updateUser(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long id) {
		userService.deleteUser(id);
	}

	@DeleteMapping
	public void deleteUser() {
		userService.deleteUser();
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDto request) {
		return userService.login(request);
	}
	
	@PostMapping("/logout")
	public String logout(@RequestBody LogoutRequestDto request) {
		return userService.logout(request);
	}

}
