package com.exam.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;

@Data
public class RentVO {

	private Integer rentNo;
	private Integer bookNo;
	private String bookName;
	private Integer rentPrice;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date rentDate;
	
	private String rentStatus;
}
 