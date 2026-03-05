package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.post.repository.Posts;
import com.example.demo.post.repository.PostsRepository;
import com.example.demo.repository.Customer;

@SpringBootApplication
@EnableJpaAuditing
public class Ex03JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex03JpaApplication.class, args);
	}

	private	static final Logger	log	= LoggerFactory.getLogger(Ex03JpaApplication.class);
	
	@Bean
	public	CommandLineRunner demo(PostsRepository	repository)	{
		return	(args)	->	{
	//		save	a	few	customers
		repository.save(new	Posts("t1", "010" ,"Jack" ));
		repository.save(new	Posts("t2","111" ,"Chloe"	));
		repository.save(new	Posts("t3","222" ,"Kim"	));
		repository.save(new	Posts("t4", "333" ,"David"));
		repository.save(new	Posts("t5",	"444" ,"Michelle"));
		 };
	}

}
