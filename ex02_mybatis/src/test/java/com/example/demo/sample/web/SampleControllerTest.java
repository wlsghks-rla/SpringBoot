package com.example.demo.sample.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = SampleController.class)
public class SampleControllerTest {

	@Autowired MockMvc mockMvc;
	
	@Test
	@DisplayName("rest 서버 테스트: get")
	public void get() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(".ex1"))
		       .andExpect(status().isOk())
		       .andDo(print());
	}
}
