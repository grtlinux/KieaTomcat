package org.tain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private static final boolean flag = true;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/create")
	public Account create() {
		if (!flag) {
			// repository
			Account account = new Account();
			account.setEmail("grtlinux@gmail.com");
			account.setPassword("{noop}kang");
			
			return this.accountRepository.save(account);
		} else {
			// service
			Account account = new Account();
			account.setEmail("grtlinux@gmail.com");
			account.setPassword("kang");
			
			return this.accountService.save(account);
		}
	}
}
