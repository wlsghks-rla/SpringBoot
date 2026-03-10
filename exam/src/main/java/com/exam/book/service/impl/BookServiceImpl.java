package com.exam.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.book.service.BookService;
import com.exam.book.service.BookVO;
import com.exam.book.service.RentVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	
	final BookMapper bookMapper;

	// 등록
	@Override
	public int insert(BookVO vo) {				
		return bookMapper.insert(vo);
	}

	// 조회
	@Override
	public List<BookVO> findAll() {	
		return bookMapper.findAll();
	}

	@Override
	public List<RentVO> findAllRent() {		
		return bookMapper.findAllRent();
	}

}
