package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserDTO;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired  UserMapper userMapper;	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userMapper.getUser(username);
		if(user == null) {
			throw new UsernameNotFoundException("not found");
		}
//		UserDto가 UserDetails 상속하기 전.
//		// List<RoleDTO> -> List<GrantedAtu>		
//		List<GrantedAuthority> auth = new ArrayList<>();
//		for(int i=0; i<user.getRoles().size(); i++) {
//			auth.add(new SimpleGrantedAuthority(user.getRoles().get(i).getRoleName()));
//		}
//		return new User(user.getLoginId(), user.getPassword(), auth );
		
		return user;
	}


	@Override
	public UserDTO getUser(String loginId) {
		return userMapper.getUser(loginId);	
	}

}
