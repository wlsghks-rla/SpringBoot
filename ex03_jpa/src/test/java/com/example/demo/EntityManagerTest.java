package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.repository.Customer;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
public class EntityManagerTest {

	@Autowired EntityManager entityManager;
	
	@Commit
	@Transactional
	//@Test
	public void insert() {
		Customer cust = new Customer("hong", "012");
		entityManager.persist(cust);
		
		System.out.println("=======" + cust);
	}
	
	@Commit
	@Transactional
	//@Test
	@DisplayName("수정")
	public void update() {
		Customer cust = entityManager.find(Customer.class, 152); // 실제로 사용할 일 없고 작동원리 확인용(JpaRepository가 해줌)
		cust.setAddr("부산");
//		entityManager.merge(cust);
	}
	
	@Commit
	@Transactional
	@Test
	@DisplayName("삭제")
	public void delete() {
		Customer cust = entityManager.find(Customer.class, 152);
		entityManager.remove(cust);
	}
	
}
