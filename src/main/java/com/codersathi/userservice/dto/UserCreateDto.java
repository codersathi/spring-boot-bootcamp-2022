package com.codersathi.userservice.dto;

import lombok.Data;

@Data
public class UserCreateDto {
	private String name;
	private String address;
	private String username;
	private String password;
}
