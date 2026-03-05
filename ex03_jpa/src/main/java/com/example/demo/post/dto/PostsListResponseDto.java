package com.example.demo.post.dto;

import java.time.LocalDateTime;

import com.example.demo.post.repository.Posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto { // 전체 조회
	private Long id;
	private String title;
	private String author;
	private LocalDateTime mdoifiedDate;
	
	public PostsListResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		//this.modifiedDate = entity.getModifiedDate();
	}
	
}
