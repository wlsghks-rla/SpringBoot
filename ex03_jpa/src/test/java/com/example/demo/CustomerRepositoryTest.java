package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired CustomerRepository customerRepository;
	@Autowired AddressRepository addressrepository;
	@Transactional
	@Commit
	@Test
	public void manytoOneTest() {
		// given
		Address addr1 = Address.builder()
	                    .zipcode("000-1211")
	                    .address("대구")
	                    .detail_address("중구")
	                    .build();		
		
		Address addr2 = Address.builder()
                .zipcode("000-1222")
                .address("부산")
                .detail_address("북구")
                .build();	
		
		addressrepository.save(addr1);// 없어도 결과 나옴.
		addressrepository.save(addr2);
				
		Customer cust = Customer.builder()
                .name("홍길동")
                .phone("010-1")
                .address(List.of(addr1, addr2))
                .build();		               
		
		// when
		Customer result = customerRepository.save(cust);
		Customer customer = customerRepository.findById(result.getId()).get();
		customer.getAddress().forEach(ad -> System.out.println(ad.getDetail_address()));
		
	}

	
	@Transactional
	@Commit
	//@Test
	@DisplayName("고객정보등록") 
	public void save() {
		// given
		Address addr = Address.builder()
				              .zipcode("000-1111")
				              .address("예담학원")
				              .detail_address("중구")
				              .build();
		
		Address address = addressrepository.save(addr);
		
		Customer cust = Customer.builder()
				                .name("홍길동")
				                .phone("010-1111-1111")
//				                .address(address)
				                .build();		                	
		
		Customer result = customerRepository.save(cust);
		
		// when
		Customer customer = customerRepository.findById(result.getId()).get();
		
		// then
//		System.out.println(">>>>>>>>>>" + customer.getAddress().getDetail_address());
		assertEquals(cust.getName(), result.getName());
	}
	
	@Transactional
	@Commit
	//@Test
	@DisplayName("고객정보수정") 
	public void merge() {
		// given
		Customer cust = customerRepository.findById(252L).get();//.orElse(new Customer()); ( 단건 조회 후 진행)
		
	    //cust.setName("이순신");
		
		// when
		Customer result = customerRepository.save(cust);
		
		// then
		assertEquals(cust.getName(), result.getName());
	}
	
	@Transactional
	@Commit
	//@Test
	@DisplayName("고객정보삭제") 
	public void delete() {
		// given
		Customer cust = customerRepository.findById(252L).get();
		
	    //cust.setName("이순신");
		
		// when
		customerRepository.delete(cust); // delete는 리턴값 x
		
		// then
		Customer result = customerRepository.findById(252L).orElse(null);
		assertNull(result);
	}
	
	//@Test
	@DisplayName("이름 검색")
	public void findByName() {
		customerRepository.deleteAll();
		
//		save	a	few	customers
	    customerRepository.save(new	Customer("Jack", "010"));
	    customerRepository.save(new	Customer("Chloe", "111"));
	    customerRepository.save(new	Customer("Kim", "222"));
	    customerRepository.save(new	Customer("David", "333"));
	    customerRepository.save(new	Customer("Kim", "444"));
	    
	    // when
	    List<Customer> list = customerRepository.findByOrderByNameDesc();
	    
	    // then
//	    assertEquals(list.size(), 2);	    
	    list.forEach(c -> System.out.println(c.getName()));
	}
	
	//@BeforeEach
	public void before() {
        customerRepository.deleteAll();
		
        //		save	a	few	customers
	    customerRepository.save(new	Customer("Jack", "010"));
	    customerRepository.save(new	Customer("Chloe", "111"));
	    customerRepository.save(new	Customer("Kim", "222"));
	    customerRepository.save(new	Customer("David", "333"));
	    customerRepository.save(new	Customer("Kim", "444"));
	}
	
	//@Test
	@DisplayName("폰 검색")
	public void findByPhone() {
		// given
		String phone = "010";
		
		// when
		Customer cust = customerRepository.findByPhone(phone);
		
		// then
		assertEquals(cust.getPhone(), phone);
	}
	
	//@Test
	@DisplayName("Native Query")
	public void query() {
		// given
		
		// when
		List<Map<String, Object>> map = customerRepository.findAllByPhone();
		
		// then
		map.forEach(m -> System.out.println(m.get("name") + " " + m.get("id")));
	}
	
	
}
