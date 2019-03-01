package org.tain.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Name name;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
	})
	private Address address;
	
	public User() {}
	public User(
			Name name,
			String email,
			Address address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public String toString() {
		return String.format("User[id=%d, %s, email=%s, %s]", id, name, email, address);
	}
}
