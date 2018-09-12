package com.checklist.management.model;

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
	
	public CheckList(Integer checkListId, String taskDescription, String completionStatus) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkListId == null) ? 0 : checkListId.hashCode());
		result = prime * result + ((completionStatus == null) ? 0 : completionStatus.hashCode());
		result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckList other = (CheckList) obj;
		if (checkListId == null) {
			if (other.checkListId != null)
				return false;
		} else if (!checkListId.equals(other.checkListId))
			return false;
		if (completionStatus == null) {
			if (other.completionStatus != null)
				return false;
		} else if (!completionStatus.equals(other.completionStatus))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	 
	
}
