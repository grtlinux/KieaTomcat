package org.tain.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan(value = { "org.tain.mybatis"})
public class HelloMybatis03Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloMybatis03Application.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		
		return sqlSessionFactoryBean.getObject();
	}
}
