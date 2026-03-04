package com.example.demo.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample.service.SampleService;

@SpringBootTest
public class SampleServiceTest {

	@Autowired SampleService sampleService;
	
	@Test
	public void add() {
		sampleService.add("123456");
	}
}
