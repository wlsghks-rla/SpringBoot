package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.BoardVO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	final BoardMapper boMapper;
	
	@Override
	public List<BoardVO> findAll() {
		// TODO Auto-generated method stub
		return boMapper.findAll();
	}

	@Override
	public BoardVO findById(int id) {
		// TODO Auto-generated method stub
		return boMapper.findById(id);
	}

	@Override
	public int insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return boMapper.insert(vo);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return boMapper.delete(id);
	}

}
