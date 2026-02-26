package com.example.demo.hr.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
@Slf4j // log.info를 위해서
@SpringBootTest
public class EmpMapperTest {

	@Autowired EmpMapper empMapper;	
	
	@Test
	@DisplayName("프로시저 호출")
	public void insertDeptProc() {
		DepartmentDTO dto = DepartmentDTO
		           .builder()
		           .departmentName("AI개발")
		           .managerId("100")
		           .locationId("1400")
		           .build();
        empMapper.insertDeptProc(dto);
	}
	
//	@Test
	@DisplayName("다건 삭제")
	public void deleteByIds() {
		// given
		Integer[] employeeId = new Integer[] {201,202,300};
		
		// when
		Integer cnt = empMapper.deleteByIds(employeeId);
		System.out.println("처리건수 : " + cnt);
	}
	
//	@Test
	@DisplayName("단건삭제")
	public void deleteById() {
		// given
		Integer id = 300;
		
		// when
		int result = empMapper.deleteById(id);
		
		// then
		System.out.println(result);		
	}
	
//	@Test
	@DisplayName("동적쿼리")
	public void findByDeptAndName() {
		// given
		String dno = null; //"90";
		String fname = null;//"King";
		
		// when
		List<EmpVO> list = empMapper.findByDeptAndName(dno, fname);
		
		// then
		System.out.println(list);
	}
	
//	@Test
	@DisplayName("사원조회 페이징")
	public void findallPage() {
		// 사원전체조회
		int pageNum = 2;
		int pagesize = 3;
	    PageInfo<EmpVO> page = PageHelper.startPage(pageNum, pagesize)
						                 .doSelectPageInfo(() -> empMapper.findall(null));
	    
	    
	    System.out.println(page.getList());
	    log.info("TotalCount : {}, CurrentPage : {}, PageSize : {}, TotalPage : {}"
	              ,page.getTotal()
	              ,page.getPageNum()
	              ,page.getPageSize()
	              ,page.getPages());
	}
	
//	@Test
	@DisplayName("사원조회(VO)")
	public void findall() {
		// given
		String order = "department_id";
		// when
		List <EmpVO> list = empMapper.findall(order);
				
		// then
//		assertEquals("King", list.get(0).getLastName() );
		list.stream().forEach(System.out::println);
	}
	
	
//	@Test
	@DisplayName("사원단건조회(VO)")
	public void findById() {
		// given
		Integer id = 100;
				
		// when
		EmpVO vo = empMapper.findById(id);
		
		// then
		assertEquals(id.toString(), vo.getEmployeeId());
				
		System.out.println();
				
	}

//	@Test
	@DisplayName("사원목록조회 (맵)")
	public void findallMap() {
		// when
		List <Map <String, Object>> list = empMapper.findallMap();
		
		// then
		assertEquals("King", (String)list.get(0).get("LAST_NAME"));
		list.stream().forEach(emp -> System.out.println(emp.get("firstName")));
	}
	
//	@Test
	@DisplayName("사원번호조회 (맵)")
	public void test() {
		// given
		Integer id = 100;
		
		// when
		Map<String, Object> map = empMapper.findByIdMap(id);
		Integer result = ((BigDecimal)map.get("employeeId")).intValue(); // NUmber : bigdecimal
		
		// then(결과)
		assertEquals(id, result);
		System.out.println(map.get("firstName") + " : " +map.get("LAST_NAME"));
		
	}
	
}
