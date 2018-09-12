package com.checklist.management.test.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.checklist.management.CheckListManagement.CheckListManagementApplicationTests;
import com.checklist.management.model.CheckList;
import com.checklist.management.repository.CheckListRepository;
import com.checklist.management.service.impl.CheckListServiceImpl;

public class CheckListServiceImplTest extends CheckListManagementApplicationTests {
	
	@Mock
	private CheckListRepository checkListRepository;
	
	@InjectMocks
	private CheckListServiceImpl checkListServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRetrieveAllCheckList() {
		List<CheckList> checkList = new ArrayList<CheckList>();
		
		checkList.add(new CheckList(1100, "Y", "Learn Angular"));
		checkList.add(new CheckList(1101, "N", "Learn AWS"));
		checkList.add(new CheckList(1101, "Y", "Learn React Js"));
		
		when(checkListRepository.findAll()).thenReturn(checkList);
		List<CheckList> result = checkListServiceImpl.retrieveAllCheckList();
		
		assertEquals(3, result.size());
		
	}
	
	@Test
	public void testCreateCheckList() {
		CheckList saveCheckList = new CheckList(1104, "Learn Node", "Y");
		
		when(checkListRepository.save(saveCheckList)).thenReturn(saveCheckList);
		CheckList result = checkListServiceImpl.createCheckList(saveCheckList);
		
		assertEquals("Learn Node", result.getTaskDescription());
		
	}
	
	@Test
	public void testRetrieveCheckList() {
		
		when(checkListRepository.findById(1100)).thenReturn(Optional.of(new CheckList(1100, "Learn Angular", "Y")));
		
		CheckList result = checkListServiceImpl.retrieveCheckList(1100);
		
		assertEquals("Y", result.getCompletionStatus());
		
	}
}
