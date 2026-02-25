package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;


//@Configuration
public class RootConfig {

	// DataSource Bean 등록
//		@Bean // 외부 소스 주입가능
		public DataSource dataSource() { // datasource - connection pool 이름
			HikariDataSource dataSource = new HikariDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xe");
			dataSource.setUsername("hr");
			dataSource.setPassword("hr");
			dataSource.setMaximumPoolSize(5); // 풀 사이즈 변경
			dataSource.setConnectionTimeout(1000); // 커넥션 대기 시간
			return dataSource;
		}
		
		// SqlSessionFactory Bean 등록
//		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { // SqlSessionFactory: jdbc 연결과정 대신
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource(dataSource);
//			factoryBean.setMapperLocations(
//					new PathMatchingResourcePatternResolver().getResources("classpath*:/mappers/**/*.xml"));
//
//			org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//			configuration.setMapUnderscoreToCamelCase(true);
	    //default: org.apache.ibatis.logging.slf4j.Slf4jImpl
	    //configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
			//factoryBean.setConfiguration(configuration);
			return factoryBean.getObject();
		}
}
