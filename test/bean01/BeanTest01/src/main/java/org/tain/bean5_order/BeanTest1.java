package org.tain.bean5_order;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanTest1 {

	@Autowired
	private List<Person> people;
	
	public BeanTest1() {
		System.out.println("BeanTest1 생성 ");
	}
	
	@PostConstruct
	public void hello() {
		people.stream().forEach(x->x.eat());
	}
}
