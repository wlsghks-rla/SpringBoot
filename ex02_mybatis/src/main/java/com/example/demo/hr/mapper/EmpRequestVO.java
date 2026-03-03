package com.example.demo.hr.mapper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class  EmpRequestVO {
	String employeeId;
	
	// https://github.com/cyannara/springboot/blob/main/springboot03_controller.md - bean validation 참고
	@Size(min = 10, max = 20, message = "글자길이는 10 에서 20 글자 사이 입니다.")
	String firstName;
	
	@NotEmpty(message="성 입력은 필수입니다.")
	String lastName;

	@Email(message= "{valid.email}")
	@NotEmpty(message= "{valid.notnull}")
	String email;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	Date  hireDate;
	
	Integer salary;
	
	Double commissionPct;
	
	@NotEmpty
	String jobId;
	
	String departmentId;
	String managerId;
	
	@Pattern(regexp = "0\\d{1,2}-\\d{1,4}-\\d{4}", message = "xxx-xxxx-xxxx 형식")
	String phoneNumber;
	}
