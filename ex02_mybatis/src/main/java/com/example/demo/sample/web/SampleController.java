package com.example.demo.sample.web;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sample.mapper.SampleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 핸들러 return 결과가 json(수업 때 주로), xml로 자동변환
public class SampleController {

	
	@GetMapping("/ex1") // command handler
	public SampleVO ex1( SampleVO vo) { //SampleVO : command 객체
		
		log.info(vo.toString());
		return vo;
	}
	
	@Tag(name= "Ticket API") 
	@Operation(summary = "회원조회",  
			description = "회원정보를 조회합니다.",  
			responses = {  
			@ApiResponse(responseCode = "200", description = "등록 성공"), 
			@ApiResponse(responseCode = "400", description = "잘못된 요청") 
			}) 
			@Parameter(description = "등록할 회원 정보", example = "{username: '홍길동', addr:'대구'}")  
	//0227
	@PostMapping("/ex1") // command handler
	public SampleVO ex11(@RequestBody SampleVO vo) { //SampleVO : command 객체		
		log.info(vo.toString());
		return vo;
	}
	
	// 상태코드 변경(ResponseEntity)
	@PutMapping("/ex1") // command handler
	public ResponseEntity<SampleVO> ex12(@RequestBody SampleVO vo) { //SampleVO : command 객체		
		log.info(vo.toString());
		return new ResponseEntity<SampleVO>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/ex2") // ex?name = ~~
	public String ex2(@RequestParam(required = false ,
	                                defaultValue = "park",
	                                name = "nm") String name,
			                                     Integer age,
			                                     String hobby) { // @RequestParam(required = true) 값이 없으면 null이아닌 오류(400번)
		                                                           // int는 null 불가 integer는 null 가능 가능하면 integer 쓸것
		log.info(name, age);
		return name + " : " + age;
	}
	
	@GetMapping("/ex3/{name}/{age}")
	public String ex3(@PathVariable String name,
			          @PathVariable Integer age) {		
		log.info(name, age);
		return name + " : " + age;
	}
	
	// 0227
	@GetMapping("/ex4")
	public SampleVO ex4() {
		SampleVO vo = SampleVO.builder()
			      .name("홍길동")
			      .age(20)
			      .hobby(List.of("read", "game"))
			      .regDate(new Date()) // 1970 ~ milisecond
			      .build();
		return vo;
	}
	
	@GetMapping("/ex5")
	public List<SampleVO> ex5() {
		return List.of(SampleVO.builder()
				       .name("홍길동")
					   .age(20)
					   .hobby(List.of("read", "game"))
					   .regDate(new Date())
					   .build(),
					   SampleVO.builder()
				       .name("홍길동")
					   .age(20)
					   .hobby(List.of("read", "game"))
					   .regDate(new Date()) 
					   .build());
		
					   
	}
	
	
}
