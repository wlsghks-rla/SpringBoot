package com.example.demo.hr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.aop.PrintExecutionTime;
import com.example.demo.hr.mapper.EmpMapper;
import com.example.demo.hr.mapper.EmpRequestVO;
import com.example.demo.hr.mapper.EmpVO;
import com.example.demo.hr.service.EmpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpServiceImpl implements EmpService{

	final EmpMapper empMapper;
	
	@Override
	@PrintExecutionTime
	public List<EmpVO> findall(String order) {
		return empMapper.findall(order);
	}

	@PrintExecutionTime
	@Override
	public EmpVO findById(int id) {
		return empMapper.findById(id);
	}


	@Override
	public int update(EmpVO vo) {
		return empMapper.update(vo);
	}

	@Transactional
	@Override
	public int deleteById(Integer employeeId) {
		// 자식테이블 삭제
		return empMapper.deleteById(employeeId);
	}

	@Transactional
	@Override
	public int insert(EmpRequestVO vo) {
		// 로그인
		
		// 사원등록
		return empMapper.insert(vo);
		
	}
}
