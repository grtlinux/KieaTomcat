package org.tain.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

	private Map<String, Account> accounts = new HashMap<>();
	private Random random = new Random();
	
	public Account save(Account account) {
		account.setId(this.random.nextInt());
		this.accounts.put(account.getEmail(), account);
		return account;
	}
	
	public Account findByEmail(String email) {
		return this.accounts.get(email);
	}
}
