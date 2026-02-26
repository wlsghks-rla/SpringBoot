package com.example.demo.hr.mapper;

import java.util.List;
import java.util.Map;

//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper //-> MapperScan으로 대체가능
public interface EmpMapper {
	
	// 프로시저	
	void insertDeptProc(DepartmentDTO dto);
	
	// 다건 삭제
	int deleteByIds(Integer[] employeeId);
	
	// 삭제
	int deleteById(Integer employeeId);
	
	
	// 동적 쿼리
	public List<EmpVO> findByDeptAndName(
			@Param("deptId") String dept,
			@Param("fname")String name);

	
	public EmpVO findById(int id);	
	public List<EmpVO> findall(String order); 
	
	// 단건 조회
//	@Select("SELECT * FROM employees WHERE employee_id = 100")
	public Map<String, Object> findByIdMap(int id); 
	
	// 여러건 조회
//	@Select("SELECT * FROM employees WHERE employee_id = 100")
	public List<Map<String, Object>> findallMap(); 
	
	
	
}
