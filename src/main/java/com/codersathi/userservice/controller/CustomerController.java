package com.codersathi.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")
public class CustomerController {

	@GetMapping("/customer")
	public String sayHelloCustomer() {
		return "Hello Customer!";
	}
}
