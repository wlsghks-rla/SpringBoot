package com.exam.book.web;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.exam.book.service.BookService;
import com.exam.book.service.BookVO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	
	final BookService bookService;
	
	@Value("${file.upload}")
	String path;
	
	// 홈페이지
	@GetMapping("/")
	public String home() {
		return "book/home";
	}

	// 등록페이지 이동
	@GetMapping("book/register")
	public void register(Model model, 
			             @ModelAttribute("book") BookVO vo) {		
	}
	
	// 등록처리
	@PostMapping("book/register")
	public String register(@Valid
			               @ModelAttribute("book") BookVO vo,
			               BindingResult bindingResult,
			               MultipartFile file) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "book/register";
		}
		
		String fileName = file.getOriginalFilename();
		file.transferTo(new File(path, fileName));
		
		vo.setBookCoverimg(fileName);
		
		bookService.insert(vo);
		return "redirect:/book/list";
	}
	
	// 전체 조회
	@GetMapping("book/list")
	public void list(Model model) {
		model.addAttribute("list", bookService.findAll());
	}
	
	// 대여 목록 조회
	@GetMapping("book/rent")
	public void rent(Model model) {
		model.addAttribute("list", bookService.findAllRent());
	}
}
