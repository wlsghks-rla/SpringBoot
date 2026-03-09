package com.example.demo.sample.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleRestController {

	@GetMapping("/sample")  // internalResourceResolver
	public void sample(Model model) {
//		int a = 5/0;
		model.addAttribute("today", new Date().toString());
//		return "/sample"; // viewResolver : templates(동적파일들)/sample.html
	}
}
