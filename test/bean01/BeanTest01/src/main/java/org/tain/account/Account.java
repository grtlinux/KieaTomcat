package org.tain.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

	private Integer id;
	private String email;
	private String password;
	private String[] roles;
}
