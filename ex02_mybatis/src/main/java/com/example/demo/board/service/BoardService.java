package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.mapper.BoardVO;

public interface BoardService {

	// 전체조회
	List<BoardVO> findAll();
	
	// 단건조회
	BoardVO findById(int id);
	
	// 등록
	int insert(BoardVO vo);
	
	// 삭제
	int delete(int id);
}
