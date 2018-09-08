package com.checklist.management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.checklist.management.exception.UserNotFoundException;
import com.checklist.management.model.User;
import com.checklist.management.repository.UserRepository;
import com.checklist.management.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User retrieveUser(Integer id){
		Optional<User> savedUser = userRepository.findById(id);
		if(savedUser.isPresent() == false)
			throw new UserNotFoundException("id-"+id);
		
		return savedUser.get();
	}

}
