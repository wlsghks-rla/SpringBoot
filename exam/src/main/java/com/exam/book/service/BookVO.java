package com.exam.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookVO {
	private Integer bookNo;
	
	@NotEmpty(message="도서명이 입력되지 않았습니다.")
	private String bookName;
	
	private String bookCoverimg;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date bookDate;
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;

}
