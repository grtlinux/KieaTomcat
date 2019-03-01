package org.tain.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.account.Account;
import org.tain.account.AccountService;
import org.tain.utils.ClassUtil;

@Component(value = "data.CreateAccount")
public class CreateAccount {

	private static final boolean flag = true;
	
	public CreateAccount() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}

	@Autowired
	private AccountService accountService;
	
	@Bean(value = "data.CreateAccount.createAccount")
	public void createAccount() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Account account = new Account();
		account.setEmail("grtlinux@gmail.com");
		account.setPassword("kang");
		this.accountService.save(account);
	}
}
