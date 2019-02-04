package org.tain.sec05.exam07_andthen_compose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

	private String name;
	private String id;
	private Address address;
}
