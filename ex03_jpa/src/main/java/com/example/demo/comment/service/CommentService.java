package com.example.demo.comment.service;

import com.example.demo.comment.dto.CommentRequestDto;

public interface CommentService {

	Long insert(CommentRequestDto dto);
}
