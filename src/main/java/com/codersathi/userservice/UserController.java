package com.codersathi.userservice;

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

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createUser(@RequestBody User user) {
		 userService.createUser(user);
		 return "Success!";
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long id) {
		System.out.println("User ID "+ id);
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
		userService.deleteUser();;
	}
	
	private User getStaticUser() {
		User user = new User();
		user.setId(1L);
		user.setName("Milan");
		return user;
	}

}
