package com.codersathi.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping
	public User getUser() {
		return getStaticUser();
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		System.out.println("Update method called.");
		User originalUser = getUser();
		originalUser.setName(user.getName());
		originalUser.setId(2L);
		System.out.println("User Update Success!");
		return originalUser;
	}

//	@DeleteMapping
	// TODOD

	private User getStaticUser() {
		User user = new User();
		user.setId(1L);
		user.setName("Milan");
		return user;
	}

}
