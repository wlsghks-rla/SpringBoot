package com.example.demo.comment.dto;

import com.example.demo.comment.repository.Comments;
import com.example.demo.post.repository.Posts;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
	private String comment;
	private Long postsId;
	private Long customerId;
	private Posts posts;
	

	public Comments toEntity() {
		Comments comments = Comments.builder()
				.comment(comment)
				.posts(posts)
				.build();
		
		return comments;
	}
}
