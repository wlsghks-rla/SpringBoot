package com.example.demo.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sample.mapper.SampleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 핸들러 return 결과가 json(수업 때 주로), xml로 자동변환
public class SampleController {

	
	@GetMapping("/ex1") // command handler
	public String ex1( SampleVO vo) { //SampleVO : command 객체
		
		log.info(vo.toString());
		return vo.toString();
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
}
