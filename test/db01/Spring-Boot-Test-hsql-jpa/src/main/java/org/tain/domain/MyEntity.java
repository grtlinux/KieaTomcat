package org.tain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String value;
	
	public MyEntity() {}
	
	public MyEntity(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "MyEntity [id=" + id + ", value=" + value + "]";
	}
}
