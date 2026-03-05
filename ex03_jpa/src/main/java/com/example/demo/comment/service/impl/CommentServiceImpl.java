package com.example.demo.comment.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.comment.dto.CommentRequestDto;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.comment.service.CommentService;
import com.example.demo.post.repository.Posts;
import com.example.demo.post.repository.PostsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	final CommentRepository commentRepository;
	final PostsRepository postsRepository;
	
	@Override
	public Long insert(CommentRequestDto dto) {
		
		Posts posts = postsRepository.findById(dto.getPostsId()).get();
		dto.setPosts(posts);
		return commentRepository.save(dto.toEntity()).getId();
	}

}
