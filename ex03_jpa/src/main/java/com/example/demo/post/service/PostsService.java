package com.example.demo.post.service;

import org.springframework.data.domain.Page;

import com.example.demo.post.dto.PostsListResponseDto;
import com.example.demo.post.dto.PostsResponseDto;
import com.example.demo.post.dto.PostsSaveRequestDto;
import com.example.demo.post.dto.PostsUpdateRequestDto;

public interface PostsService {

	public Long save(PostsSaveRequestDto requestDto); // 등록
	public Long update(Long id,PostsUpdateRequestDto requestDto); // 수정
	public Long delete(Long id);	
	public PostsResponseDto findById(Long id); // 단건
	public Page<PostsListResponseDto> findAllDesc(int pageNo) ; // 전체
	
}
