package com.checklist.management.service;

import com.checklist.management.model.User;

public interface UserService {

	public User createUser(User user);

	public User retrieveUser(Integer id);
}
