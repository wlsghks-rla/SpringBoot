package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy	=	GenerationType.AUTO)
	private Long id;
	
	private String zipcode;
	private String address;
	private String detail_address;
	
	
//	@OneToOne
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	Customer customer;
}
