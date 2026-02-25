package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpMapperTest {

	@Autowired EmpMapper empMapper;
	
	
	@Test
	@DisplayName("사원단건조회") // 화면 이름 변경
	public void getEmp() { //TDD(테스트주도개발)
		// given
		Integer employeeId = 100; // 
		
		// when
		EmpVO vo = empMapper.getEmp(employeeId);
		
		// then
		assertEquals(employeeId.toString(), vo.getEmployeeId()); // 성공
//		assertEquals("101", vo.getEmployeeId()); // 실패 -> mvnw package에서 통과해야 가능.
	}
}
