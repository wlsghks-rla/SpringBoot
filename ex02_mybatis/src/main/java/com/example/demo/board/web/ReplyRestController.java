package com.example.demo.board.web;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.mapper.ReplyVO;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ReplyRestController {
  

	private final ReplyMapper replyMapper;

	// 게시글의 댓글 조회
	@GetMapping("/board/{bno}/reply")
	public List<ReplyVO> getreply(@PathVariable Integer bno) {
		System.out.println(replyMapper.findAllBno(bno));
	  return replyMapper.findAllBno(bno);	
	}
	

	// 댓글 등록
	@PostMapping("/reply")
	public ReplyVO insert(@RequestBody ReplyVO vo) {
		replyMapper.insertReply(vo);
		return replyMapper.findByRno(vo.getRno());
	}
	
	
	
	// 댓글 삭제
	@DeleteMapping("/reply/{rno}")
	public Integer delete(@PathVariable Integer rno) {
		replyMapper.delReply(rno);
		return rno;
	}
	
}
