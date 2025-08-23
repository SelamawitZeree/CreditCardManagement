package com.creditCardManagement;

import com.creditCardManagement.domain.Account;
import com.creditCardManagement.repository.AccountRepository;
import com.creditCardManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CreditCardManagementApplication  {//implements CommandLineRunner

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(CreditCardManagementApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Account account = new Account();
//		account.setAccountNumber("12345");
//		account.setBalance(1000.0);
//		accountRepository.save(account);
//
//		accountRepository.findById(account.getId())
//				.ifPresent(a -> System.out.println("Account found: " + a.getAccountNumber() + " Balance: " + a.getBalance()));
//	}
	}

