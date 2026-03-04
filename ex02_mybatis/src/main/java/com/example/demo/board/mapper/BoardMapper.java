package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	// 전체조회
	List<BoardVO> findAll();
	
	// 단건조회
	BoardVO findById(int id);
	
	// 등록
	int insert(BoardVO vo);
	
	// 삭제
	int delete(int id);
}
