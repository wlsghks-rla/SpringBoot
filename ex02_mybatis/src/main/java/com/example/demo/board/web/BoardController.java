package com.example.demo.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.board.mapper.BoardVO;
import com.example.demo.board.service.BoardService;
import com.example.demo.hr.mapper.EmpVO;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private final ReplyRestController replyRestController;

	final BoardService boService;

	
	// 전체 조회
	@GetMapping("board/list")
	public void list(Model model) {
		model.addAttribute("list", boService.findAll());
	}
	
	// 단건 조회
	@GetMapping("board/info/{id}")
	public String info(Model model, @PathVariable Integer id) {
		model.addAttribute("board", boService.findById(id));
		
		return "board/info";
	}
	
	// 등록페이지 이동
	@GetMapping("board/register")
	public void register(Model model, @ModelAttribute("board") BoardVO vo) {
		
	}
	
	// 등록 처리
	@PostMapping("board/register")
	public String register(@ModelAttribute("board") BoardVO vo) {
		boService.insert(vo);
		return "redirect:/board/list";
	}
	
	// 삭제
	@GetMapping("board/delete/{id}")
	public String delete(@PathVariable Integer id) {
		boService.delete(id);
		return "redirect:/board/list";
	}
}
