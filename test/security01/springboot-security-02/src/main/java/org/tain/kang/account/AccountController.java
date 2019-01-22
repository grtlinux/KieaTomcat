package org.tain.kang.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/create")
	public Account create() {
		Account account = new Account();
		account.setEmail("grtlinux@gmail.com");
		//account.setPassword("{noop}kang");
		account.setPassword("kang");
		
		return this.accountService.save(account);
	}
}
