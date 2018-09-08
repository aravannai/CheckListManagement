package com.checklist.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CheckList{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer checkListId;
	
	private String taskDescription;
	
	private String completionStatus;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private User user;
	
	public CheckList() {
		super();
	}
	
	public CheckList(Integer checkListId, String taskDescription, String completionStatus, Date timeOfCompletion) {
		super();
		this.checkListId = checkListId;
		this.taskDescription = taskDescription;
		this.completionStatus = completionStatus;
	}
	
	
	public Integer getCheckListId() {
		return checkListId;
	}


	public void setCheckListId(Integer checkListId) {
		this.checkListId = checkListId;
	}


	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public User getUser() {
		return user;
	}

	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CheckList [id=" + checkListId + ", taskDescription=" + taskDescription + ", completionStatus=" + completionStatus
				+  "]";
	}
	
	
	
	 
	
}
