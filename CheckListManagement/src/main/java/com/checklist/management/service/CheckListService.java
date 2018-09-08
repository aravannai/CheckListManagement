package com.checklist.management.service;

import java.util.List;

import com.checklist.management.model.CheckList;

public interface CheckListService {

	public List<CheckList> retrieveAllCheckList();
	
	public CheckList retrieveCheckList(Integer id);
	
	public CheckList createCheckList(CheckList checklist);
}
