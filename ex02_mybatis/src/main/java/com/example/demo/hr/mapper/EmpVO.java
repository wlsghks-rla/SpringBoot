package com.example.demo.hr.mapper;

import java.util.Date;


import lombok.Data;

@Data
//@Alias("Employee")
public class  EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	Date  hireDate;
	Integer salary;
	Double commissionPct;
	String jobId;
	String departmentId;
	String managerId;
	}
