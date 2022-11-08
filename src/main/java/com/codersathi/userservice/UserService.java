package com.codersathi.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
	}

	public User getUser(Long userId) {
		System.out.println("User id in service "+userId);
		Optional<User> user =  userRepository.findById(userId);
		return user.get();
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

	
}
