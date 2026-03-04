package com.example.demo.hr.service;

import java.util.List;

import com.example.demo.hr.mapper.EmpRequestVO;
import com.example.demo.hr.mapper.EmpVO;

public interface EmpService {

	// 전체조회
	public List<EmpVO> findall(String order);
	// 단건조회
	public EmpVO findById(int id);	
	// 등록 3/3
	int insert(EmpRequestVO vo);		
	// 수정 3/3
	int update(EmpVO vo);
	// 삭제
	int deleteById(Integer employeeId);
}
