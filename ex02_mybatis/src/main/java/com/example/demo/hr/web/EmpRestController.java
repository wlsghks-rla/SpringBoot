package com.example.demo.hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hr.mapper.DepartmentDTO;
import com.example.demo.hr.mapper.EmpMapper;
import com.example.demo.hr.mapper.EmpVO;

@RestController
public class EmpRestController {

	@Autowired EmpMapper empMapper;
	
	@GetMapping("/api/emp")
	@ResponseBody // 일반 controller일 때(json) 
	public List<EmpVO> emp() {
		return empMapper.findall(null);
	}
	
	@GetMapping("/api/dept/insert")
//	http://127.0.0.1:8080/api/dept/insert?managerId=100&locationId=1700&departmentName=%EA%B0%9C%EB%B0%9C2%ED%8C%80
	public DepartmentDTO insert(DepartmentDTO dto) {
		// service 대신 mapper 호출		
		empMapper.insertDeptProc(dto);
		
		return dto;
	}
}
