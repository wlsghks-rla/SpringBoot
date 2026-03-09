package com.example.demo.socket;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GreetingController {

  private final SimpMessagingTemplate template;

  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

  // 모두에게 알림 보내기
  @GetMapping("/notify")
  public String notfiy(HelloMessage message) {
	  String text = new Date().toLocaleString() + "공지등록";
	  this.template.convertAndSend("/topic/notify", text);
	  
	  return "sample";
  }
  
  @GetMapping("/personNotify")
  public String personNotify() {
	  
	  this.template.convertAndSendToUser("user", "/queue/personNotice", "개인메세지");
	  
	  return "home";
	  
  }
}