package com.exam.book.service;

import java.util.List;

public interface BookService {

	// 등록
	public int insert(BookVO vo);
		
	// 조회
	public List<BookVO> findAll();
	
	// 대여목록조회
	public List<RentVO> findAllRent();
	
	
}
