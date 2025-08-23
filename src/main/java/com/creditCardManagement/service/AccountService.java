package com.creditCardManagement.service;

import com.creditCardManagement.domain.Account;
import com.creditCardManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public Account getAccount(Long accountId){
        return accountRepository.findById(accountId)
                .orElseThrow(()->new RuntimeException(" Account not found "));
    }
    // Create account
    public Account createAccount(String accountNumber, double balance) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        Account saved = accountRepository.save(account);

        // publish the created account event
        eventPublisher.publishEvent(saved);
        return saved;
    }

    // Deposit
    public Account deposit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        Account saved = accountRepository.save(account);

        // publish updated account event
        eventPublisher.publishEvent(saved);
        return saved;
    }

    // Withdraw
    public Account withdraw(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        Account saved = accountRepository.save(account);

        eventPublisher.publishEvent(saved);
        return saved;
    }

    // Delete
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        accountRepository.delete(account);

        // optional: publish deletion event
        eventPublisher.publishEvent("Deleted account with ID: " + accountId);
    }
}
