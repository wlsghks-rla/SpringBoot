package com.example.demo.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.service.UserDTO;

@Mapper
public interface UserMapper {

	public UserDTO getUser(String loginId);
	
	public List<String> getRole(Long id);
}
