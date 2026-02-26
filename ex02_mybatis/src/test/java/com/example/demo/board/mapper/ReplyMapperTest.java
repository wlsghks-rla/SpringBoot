package com.example.demo.board.mapper;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyMapperTest {

	@Autowired ReplyMapper replyMapper;
	
//	@Test
	@DisplayName("전체 조회")
	public void findAll() {
		// given
		Integer id = 1;
		
		// when
		List<ReplyVO> list = replyMapper.findAllBno(id);
		
		// then
		list.stream().forEach(reply -> System.out.println(reply));
	}
	
//	@Test
	@DisplayName("단건 조회")
	public void findById() {
		// given
		Integer id = 1;
		
		// when
		ReplyVO vo = replyMapper.findById(id);
		
		// then
		System.out.println(vo);
	}
	
//	@Test
	@DisplayName("등록")
	public void insertReply() {
		// given
				
		String bno = "2";
		String reply = "reply2";
		String replyer = "replyer2";
		
		ReplyVO vo = ReplyVO.builder()
				.bno(bno)
				.reply(reply)
				.replyer(replyer)
				.build(); // builder.build() 빈 배열 생성.
		// when
		int result = replyMapper.insertReply(vo);		
	}
	
	@Test
	@DisplayName("삭제")
	public void delReply() {
		// given
		Integer id = 1;
		
		// when
		int result = replyMapper.delReply(id);		
	}
	
	
	
	
}
