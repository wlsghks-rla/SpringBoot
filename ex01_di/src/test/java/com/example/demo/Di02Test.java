package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.di02.Restaurant;

@SpringBootTest
public class Di02Test {

	@Autowired Restaurant restaurant;
	
	@Test
	public void Test() {
		restaurant.getChief().toString();
	}
}
