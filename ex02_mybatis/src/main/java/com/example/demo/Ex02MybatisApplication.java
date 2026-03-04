package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true) 
@SpringBootApplication
//@ComponentScan(backPackages = {"com.example.demo", "com.exampl.demo1") application의 외부 패키지가 필요할 때
@MapperScan(basePackages = "com.example.demo.**.mapper") // @Mapper를 하나하나 할 필요 x
public class Ex02MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex02MybatisApplication.class, args);
	}

}
