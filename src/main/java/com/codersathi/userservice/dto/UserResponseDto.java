package com.codersathi.userservice.dto;

import lombok.Data;

@Data
public class UserResponseDto {
	private Long id;
	private String name;
	private String address;
	private String username;
}
