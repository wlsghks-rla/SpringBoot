package com.exam;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.book.service.BookVO;
import com.exam.book.service.RentVO;
import com.exam.book.service.impl.BookMapper;

@SpringBootTest
public class BookMapperTest {
	
	@Autowired BookMapper bookMapper;
	
	//@Test
	@DisplayName("insert")
	public void insert() {
		// given
		BookVO vo = BookVO.builder()
				          .bookName("시험중")
				          .build();		
		
		// when
		int result = bookMapper.insert(vo);
		
		// then
		System.out.println(result);
	}
	
	//@Test
	@DisplayName("findAll")
	public void findAll() {
		// given
		
		// when
		List<BookVO> list = bookMapper.findAll();
		
		// then
		list.stream().forEach(l -> System.out.println(l));
	}
	
	    @Test
		@DisplayName("findAllRent")
		public void findAllRent() {
			// given
			
			// when
			List<RentVO> list = bookMapper.findAllRent();
			
			// then
			list.stream().forEach(l -> System.out.println(l));
		}
	
	

}
