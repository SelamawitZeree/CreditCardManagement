package com.creditCardManagement.controller;
import com.creditCardManagement.domain.Account;
import com.creditCardManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

//    @PostMapping
//    public Account createAccount(@RequestParam String accountNumber, @RequestParam double balance){
//        return accountService.createAccount(accountNumber, balance);
//    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account.getAccountNumber(), account.getBalance());
    }


    @PutMapping("/{accountId}/deposit")
    public Account deposit (@PathVariable Long accountId, @RequestParam double amount){
        return accountService.deposit(accountId , amount);
    }

    @PutMapping("/{accountId}/withdraw")
    public Account withdraw (@PathVariable Long accountId , @RequestParam double amount){
        return accountService.withdraw(accountId, amount);
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId){
        return accountService.getAccount(accountId);
    }

    @DeleteMapping("/{accountId}")
    public String deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
        return "Account deleted Successfuly";
    }

}
