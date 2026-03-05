package com.example.demo.comment.dto;

import com.example.demo.comment.repository.Comments;

import lombok.Getter;

@Getter
public class CommentResponseDto {

	Long id;
	String comment;
	String name;
	
	public CommentResponseDto() {}
	
	public CommentResponseDto(Comments comment) {
		
		this.id= comment.getId();
		this.comment= comment.getComment();
//		this.name= comment.getCustomer().getName();		
	}
}
