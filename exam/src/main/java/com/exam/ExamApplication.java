package com.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.exam.book.service.impl") 
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

}
