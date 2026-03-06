package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login") // security가 기본적으로 로그인페이지 제공하지만 위치 정하는 것도 가능
				.permitAll() // 아무나 접근 가능
			)
			.logout(LogoutConfigurer::permitAll);
		// @formatter:on

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean // 가상메모리에 저장
//	UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		String password = encoder.encode("1234");
//		UserDetails user = User.withUsername("user").password(password).roles("USER").build();
//		UserDetails admin = User.withUsername("admin").password(password).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}

}