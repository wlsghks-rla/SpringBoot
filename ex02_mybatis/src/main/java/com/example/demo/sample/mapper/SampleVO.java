package com.example.demo.sample.mapper;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleVO {
	@Schema(description = "사용자이름", example = "홍길동") 
	@JsonProperty("username")
	private String name;
	
	@JsonIgnore
	private Integer age;
	
	@Schema(description = "가입일자", example = "2025-01-01")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 2026-10-01로 전송시 형식 오류 대처(원래는 2026/01/01)
	@JsonFormat(pattern = "yyyy-MM-dd hh",timezone = "Asia/Seoul")
	private Date regDate;
	
	@Schema(description = "주소", example = "12345")
	private String addr;
	private List<String> hobby;
}
