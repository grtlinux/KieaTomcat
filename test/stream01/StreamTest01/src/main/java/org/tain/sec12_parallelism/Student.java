package org.tain.sec12_parallelism;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

	public enum Sex { MALE, FEMALE }
	public enum City { Seoul, Pusan }
	
	@NonNull private String name;
	@NonNull private int score;
	@NonNull private Sex sex;
	private City city;
}