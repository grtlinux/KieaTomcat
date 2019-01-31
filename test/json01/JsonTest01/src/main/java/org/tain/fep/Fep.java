package org.tain.fep;

import java.util.List;

import lombok.Data;

@Data
public class Fep {

	private String id;
	private String name;
	private String description;
	private Integer number;
	private List<Field> fields;
	
	@Data
	public static class Field {
		private String name;
		private Integer size;
		private String description;
	}
}
