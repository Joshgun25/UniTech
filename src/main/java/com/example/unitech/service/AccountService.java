package com.example.unitech.service;

import com.example.unitech.model.Account;
import com.example.unitech.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getActiveAccounts() {
        return accountRepository.findByIsActiveTrue();
    }

    public Optional<Account> findById(Long AccountId){
        return accountRepository.findById(AccountId);
    }
}
