package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface ReplyMapper {

	// 전체 조회
	public List<ReplyVO> findAllBno(int id);
	
	// 단건 조회
	public ReplyVO findByRno(int id);
	
	// 등록
	int insertReply(ReplyVO vo);
	
	// 삭제
	int delReply(int id);
}
