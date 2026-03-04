package com.example.demo.hr.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.hr.mapper.DeptMapper;
import com.example.demo.hr.mapper.EmpRequestVO;
import com.example.demo.hr.mapper.EmpVO;
import com.example.demo.hr.mapper.JobMapper;
import com.example.demo.hr.service.EmpService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class EmpController { // 03/03
	
	final EmpService empService;
	final DeptMapper deptMapper;
	final JobMapper jobMapper;
	
	@Value("${file.upload}")
	String path;

	// 전체 조회
	@GetMapping("emp/list")
	public void list(Model model) {
		System.out.println("path: " + path);
		// 조회 결과
		model.addAttribute("list", empService.findall(null));
		
//		return ""; // 주소와 같으면 생략 가능
	}
	
	// 상세 보기
	@GetMapping("emp/info/{id}")
	public String info(Model model, @PathVariable Integer id) {
		model.addAttribute("emp", empService.findById(id));
		
		return "emp/info";
	}
	
	// 등록페이지로 이동
	@GetMapping("emp/register")
	public void register(Model model, @ModelAttribute("emp") EmpVO vo) {
		// 무서목록
		model.addAttribute("deptList", deptMapper.findAll());
		model.addAttribute("jobList", jobMapper.findAll());
//		model.addAttribute("emp", vo); // @ModelAttribute("emp") 동일
	}
	
	
	// 등록처리
	@PostMapping("emp/register")
	public String registerProc(@Valid @ModelAttribute("emp") EmpRequestVO vo,
			                    BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("deptList", deptMapper.findAll());
			model.addAttribute("jobList", jobMapper.findAll());
			return "emp/register";
		}
		empService.insert(vo);
		return "redirect:/emp/list"; // redirect : 핸들러 재호출
	}
	
	// 삭제 처리
	@GetMapping("emp/delete/{id}") // emp/delete?id=???
	public String delete(@PathVariable Integer id) {
		empService.deleteById(id);
		return "redirect:/emp/list";
	}
	
	// 수정페이지로 이동
	
	// 수정 처리
	
}
