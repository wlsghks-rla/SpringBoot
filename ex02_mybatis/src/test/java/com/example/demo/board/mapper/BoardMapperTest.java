package com.example.demo.board.mapper;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardMapperTest {
	
	@Autowired BoardMapper boMapper;

	//@Test
	@DisplayName("boardFindAll")
	public void findAll() {
		// given
		// when
		List<BoardVO> list = boMapper.findAll();
		// then
		list.stream().forEach(board -> {
			System.out.println(board);
		});
	}
	
	//@Test
	@DisplayName("boardfindid")
	public void findById() {
		// given
		int id = 1;
		// when
		BoardVO list = boMapper.findById(id);
		// then
		
		System.out.println(list);
		
	}
	
	//@Test
	@DisplayName("boardInsert")
	public void insert() {
		// given
		String title = "test";
		String content = "test";
		String writer = "test";
		
		BoardVO vo = BoardVO.builder()
				     .title(title)
				     .content(content)
				     .writer(writer)
				     .build();
		// when
		int result = boMapper.insert(vo);
		
		// then		
		System.out.println(result);
		
	}
	
	@Test
	@DisplayName("boardDelete")
	public void delete() {
		// given
		int id = 23;
		// when
		int result = boMapper.delete(id);
		
		// then		
		System.out.println(result);
		
	}			
}
