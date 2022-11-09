package com.codersathi.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codersathi.userservice.dto.LoginRequestDto;
import com.codersathi.userservice.dto.LogoutRequestDto;
import com.codersathi.userservice.dto.UserCreateDto;
import com.codersathi.userservice.dto.UserResponseDto;
import com.codersathi.userservice.entity.User;
import com.codersathi.userservice.repository.UserRepository;
import com.codersathi.userservice.security.BCrypt;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(UserCreateDto userDto) {
		String originalPassword = userDto.getPassword();
		String encryptedPassword = BCrypt.hashpw(originalPassword, BCrypt.gensalt());

		log.info("Original Password {}", originalPassword);
		log.info("Encrypted Password {}", encryptedPassword);

		User user = new User();
		user.setAddress(userDto.getAddress());
		user.setName(userDto.getName());
		user.setPassword(encryptedPassword);
		user.setUsername(userDto.getUsername());

		userRepository.save(user);
	}

	public UserResponseDto getUser(Long userId) {
		System.out.println("User id in service " + userId);
		Optional<User> userOptional = userRepository.findById(userId);
		User user = userOptional.get();

		UserResponseDto response = new UserResponseDto();
		response.setAddress(user.getAddress());
		response.setName(user.getName());
		response.setUsername(user.getUsername());
		response.setId(user.getId());

		return response;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		user.setAddress("Kathmandu");
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	public void deleteUser() {
		userRepository.deleteAll();

	}

	public String login(LoginRequestDto request) {
		/**
		 * 1. check user with given username if exist check password and return status
		 * 2. if user does not exist then return user not found message
		 */

		User user = userRepository.findByUsername(request.getUsername());

		if (user == null) {
			return "User does not exist. Please register first.";
		}

		boolean checkpw = BCrypt.checkpw(request.getPassword(), user.getPassword());
		if (!checkpw)
			return "Invalid password. Please type your correct password.";

		user.setLoggedIn(true);
		userRepository.save(user);
		
		return "Success!";
	}

	public String logout(LogoutRequestDto request) {
		User user = userRepository.findByUsername(request.getUsername());

		if (user == null) {
			return "User does not exist. Please register first.";
		}

		user.setLoggedIn(false);
		userRepository.save(user);
		
		return "Success!";
	}

}
