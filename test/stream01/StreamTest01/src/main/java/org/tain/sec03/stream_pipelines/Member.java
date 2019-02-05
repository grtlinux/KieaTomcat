package org.tain.sec03.stream_pipelines;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	private String name;
	private int sex;
	private int age;
}
