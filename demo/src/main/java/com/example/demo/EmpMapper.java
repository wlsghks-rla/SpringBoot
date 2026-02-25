package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper // proxy
public interface EmpMapper {
	 public List<EmpVO> getEmpList(); // 다건 조회(배열로 받음)
	 public EmpVO getEmp(int employeeId); // 단건조회(EmpVO로 받음)
}
