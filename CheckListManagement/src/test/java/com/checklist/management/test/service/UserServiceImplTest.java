package com.checklist.management.test.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.checklist.management.CheckListManagement.CheckListManagementApplicationTests;
import com.checklist.management.model.User;
import com.checklist.management.repository.UserRepository;
import com.checklist.management.service.impl.UserServiceImpl;

public class UserServiceImplTest extends CheckListManagementApplicationTests {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRetrieveUser() {
		when(userRepository.findById(1000)).thenReturn(Optional.of(new User(1000, null)));
		
		User result = userServiceImpl.retrieveUser(1000);
		
		assertEquals(Integer.valueOf(1000), result.getUserId());
		
	}
}
