package org.tain.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Name {

	@NotNull
	@Size(max = 40)
	private String firstName;
	
	@Size(max = 40)
	private String middleName;
	
	@Size(max = 40)
	private String lastName;
	
	public Name() {}
	
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return String.format("Name[%s, %s, %s]", this.firstName, this.middleName, this.lastName);
	}
}
