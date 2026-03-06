package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.UserDTO;
import com.example.demo.service.impl.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootTest
public class UserMapperTest {

	@Autowired UserMapper userMapper;
	
	
	@Test
	@DisplayName("getUser")
	public void getUser() {
		// given
		String id = "user";
				
		// when
		UserDTO dto = userMapper.getUser(id);
		
		// then
		System.out.println(dto);
	}
	
	//@Test
	@DisplayName("getRole")
	public void getRole() {
		// given
		Long id = 2l;
				
		// when
		List<String> dto = userMapper.getRole(id);
		
		// then
		System.out.println(dto);
//		dto.stream().forEach(e -> System.out.println(e)); // resulttype string
	}
	
	
	
}
