package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public	class	Customer	{ // customer 자체가 테이블 느낌(vo에서 customer로 데이터 넘김)
				@Id
				@GeneratedValue(strategy = GenerationType.AUTO)
				private	Long	id;
				
				@Column(length = 20,	nullable = false)				
				private	String	name;
				
				@Column(length = 20,	nullable = false,	unique = true)
				private	String	phone;
				
//				@Column(length = 100)
//				private String addr;
				
				@Transient
				private Integer grade; 
								
				@Temporal(TemporalType.DATE)
				private Date regdate;
				
//				@OneToOne
//				@JoinColumn(name = "address_id")
//				private Address address;
				
				@OneToMany(mappedBy = "customer")
				private List<Address> address = new ArrayList<>();
				
				public Customer(String name, String phone) {
					super();
					this.name = name;
					this.phone = phone;
				}
}