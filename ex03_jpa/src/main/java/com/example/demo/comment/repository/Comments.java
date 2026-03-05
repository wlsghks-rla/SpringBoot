package com.example.demo.comment.repository;

import com.example.demo.post.repository.BaseTimeEntity;
import com.example.demo.post.repository.Posts;
import com.example.demo.repository.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Comments extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="comments",  columnDefinition = "clob", nullable = false)
	private String comment; // 댓글 내용     

	
	@ManyToOne
	@JoinColumn(name = "posts_id")
	private Posts posts;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customer; // 작성자

	@Builder
	public Comments(String comment, Posts posts, Customer customer) {
		this.comment = comment;
		this.posts = posts;
		this.customer = customer;
	}
	
	
}
