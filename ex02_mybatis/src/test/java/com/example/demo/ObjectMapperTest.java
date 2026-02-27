package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.sample.mapper.SampleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {

//	@Disabled // test 주석 처리 대신
	@Test
	@DisplayName("자바객체를 JSON으로 변환")
	public void toJson() throws JsonProcessingException {
		SampleVO vo = SampleVO.builder()
				      .name("홍길동")
				      .age(20)
				      .hobby(List.of("read", "game"))
				      .regDate(new Date()) // 1970 ~ milisecond
				      .build();
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(vo);
		
		System.out.println(result);
	}
	
	@Disabled
	@Test
	@DisplayName("json string을 자바객체로 변환")
	public void fromJson() throws JsonMappingException, JsonProcessingException {
		String json = "{\"name\":\"홍길동\",\"age\":20,\"hobby\":[\"read\",\"game\"]}";
		ObjectMapper mapper = new ObjectMapper();
		SampleVO vo = mapper.readValue(json, SampleVO.class);
		
		System.out.println(vo);
	}
	
}
