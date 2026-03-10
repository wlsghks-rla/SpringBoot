package com.exam.book.service.impl;

import java.util.List;

import com.exam.book.service.BookVO;
import com.exam.book.service.RentVO;

public interface BookMapper {

	// 등록
	public int insert(BookVO vo);
	
	// 조회
	public List<BookVO> findAll();
	
	// 대여목록조회
	public List<RentVO> findAllRent();
}
