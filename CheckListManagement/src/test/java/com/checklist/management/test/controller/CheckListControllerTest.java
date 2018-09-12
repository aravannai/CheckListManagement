package com.checklist.management.test.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.checklist.management.CheckListManagement.CheckListManagementApplicationTests;

public class CheckListControllerTest extends CheckListManagementApplicationTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	private MockMvc mockMvc;
	
	@Test
	public void retrieveCheckListById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/retrieveCheckList/1100").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.checkListId").exists())
		.andExpect(jsonPath("$.taskDescription").exists())
		.andExpect(jsonPath("$.completionStatus").exists())
		.andExpect(jsonPath("$.checkListId").value(1100))
		.andExpect(jsonPath("$.taskDescription").value("Learn AWS"))
		.andExpect(jsonPath("$.completionStatus").value("Y"))
		.andDo(print());
	}
	
	@Test
	public void createCheckListsForUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/users/1001/checklist")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"checkListId\":\"1103\",\"taskDescription\" : \"Learn React JS\", \"completionStatus\" : \"Y\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.checkListId").exists())
		.andExpect(jsonPath("$.taskDescription").exists())
		.andExpect(jsonPath("$.completionStatus").exists())
		.andExpect(jsonPath("$.checkListId").value(1103))
		.andExpect(jsonPath("$.taskDescription").value("Learn React JS"))
		.andExpect(jsonPath("$.completionStatus").value("Y"))
		.andDo(print());
	}
	
	
}
