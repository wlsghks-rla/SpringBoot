package com.example.demo.di02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
	
	// Java 기반 DI : 내가 만든 클래스가아닌 외부 클래스일 때 사용

	@Bean
	public Chief chief() {
		return new Chief();
	}
	
	@Bean
	public Restaurant restaurant(Chief chief) {
		return new Restaurant(chief);
	}
}
