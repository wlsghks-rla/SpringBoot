package com.example.demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/admin", "/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.successHandler(authenticationSuccessHandler())// security가 기본적으로 로그인페이지 제공하지만 위치 정하는 것도 가능
				.permitAll() // 아무나 접근 가능
			)
			.logout(LogoutConfigurer::permitAll)
			.csrf(c->c.disable());
		// @formatter:on

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

//	@Bean // 가상메모리에 저장
//	UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		String password = encoder.encode("1234");
//		UserDetails user = User.withUsername("user").password(password).roles("USER").build();
//		UserDetails admin = User.withUsername("admin").password(password).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}

}