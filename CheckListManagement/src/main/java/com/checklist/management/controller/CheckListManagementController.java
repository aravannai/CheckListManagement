package com.checklist.management.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.checklist.management.model.CheckList;
import com.checklist.management.model.User;
import com.checklist.management.service.CheckListService;
import com.checklist.management.service.UserService;

@RestController
public class CheckListManagementController {

	@Autowired
	private CheckListService checkListService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/retrieveAllCheckList")
	public List<CheckList> getAllCheckList(){
		return checkListService.retrieveAllCheckList();
	}
	
	@GetMapping(path="/retrieveCheckList/{id}")
	public CheckList getCheckList(@PathVariable Integer id){
		
		return checkListService.retrieveCheckList(id);
	}
	
	@PostMapping(path="/saveCheckList")
	public ResponseEntity<Object> createCheckList(@Valid @RequestBody CheckList checkList){
		CheckList saveCheckList = checkListService.createCheckList(checkList);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveCheckList.getCheckListId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path="/users/{id}/checklist")
	public ResponseEntity<Object> createCheckListForUser(@PathVariable Integer id, @Valid @RequestBody CheckList checklist){
		User user = userService.retrieveUser(id);
		checklist.setUser(user);
		checkListService.createCheckList(checklist);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(checklist.getCheckListId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping(path="/users/{id}/checkList")
	public List<CheckList> retrieveCheckListForUser(@PathVariable Integer id){
		User userOptional = userService.retrieveUser(id);
		return userOptional.getCheckList();
	}
	
	@PostMapping(path="/saveUsers")
	public ResponseEntity<Object> createUsers(@Valid @RequestBody User users){
		User saveCheckList = userService.createUser(users);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(saveCheckList.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
