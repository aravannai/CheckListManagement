package com.checklist.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.checklist.management.exception.CheckListNotFoundException;
import com.checklist.management.model.CheckList;
import com.checklist.management.repository.CheckListRepository;
import com.checklist.management.service.CheckListService;

@Component
public class CheckListServiceImpl implements CheckListService {

	@Autowired
	private CheckListRepository checkListRepository;
	
	@Override
	public List<CheckList> retrieveAllCheckList() {
		// TODO Auto-generated method stub
		return checkListRepository.findAll();
	}

	@Override
	public CheckList retrieveCheckList(Integer id) {
		// TODO Auto-generated method stub
		Optional<CheckList> optionalCheckList =  checkListRepository.findById(id);
		
		if(optionalCheckList.isPresent()==false)
			throw new CheckListNotFoundException("id-"+id);
		
		return optionalCheckList.get();
		
		
	}

	@Override
	public CheckList createCheckList(CheckList checklist) {
		// TODO Auto-generated method stub
		return checkListRepository.save(checklist);
	}


}
