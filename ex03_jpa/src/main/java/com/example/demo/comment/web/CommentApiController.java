package com.example.demo.comment.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.dto.CommentRequestDto;
import com.example.demo.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

	private final CommentService commentService;
	
	// 등록 처리
	@PostMapping("/api/v1/comment")
	public Long save(@RequestBody CommentRequestDto requestDto) {
		return commentService.insert(requestDto);
	}
}
