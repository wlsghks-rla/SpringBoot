package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDTO implements UserDetails{
	  private Long id;
	  private String loginId;
	  private String password;
	  private String  fullName;
	  private String  deptName;
	  
	  private List<RoleDTO> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// List<RoleDTO> -> List<GrantedAtu>		
//		List<GrantedAuthority> auth = new ArrayList<>();
//		for(int i=0; i<this.roles.size(); i++) {
//			auth.add(new SimpleGrantedAuthority(this.roles.get(i).getRoleName()));
//		}
//		return auth;
		
		return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}