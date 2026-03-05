package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Team {

	@Id
	private Integer id;
	private String teamname;
	
	
	public Team() {
		
	}
	
	public Team(String teamname) { // id는 초기화 필요 없음
		this.teamname = teamname;
	}
	
	
}
