package com.example.demo.sample.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAiTest {
	
	@Autowired
    private ChatClient.Builder chatClientBuilder;

    private ChatClient chatClient;

    @BeforeEach
    void setUp() {
        this.chatClient = chatClientBuilder.build();
    }

	@Test
	public void test() {

        String response = chatClient
        		.prompt()        		
        		.system(" ")
        		.user(" ")
                .call()
                .content();

        System.out.println(response);
	}
}
