package org.tain.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Fuga {

	private String value;
	
	public Fuga() {}
	public Fuga(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Fuga [value=" + this.value + "]";
	}
}
