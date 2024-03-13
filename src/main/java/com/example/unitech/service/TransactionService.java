package com.example.unitech.service;
import com.example.unitech.model.*;
import com.example.unitech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction makeTransfer(Account sourceAccount, Account targetAccount, BigDecimal amount) {
        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance in the source account");
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        // Set other transaction details
        // Update account balances
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));
        // Save transaction and update accounts
        transactionRepository.save(transaction);
        // Update source and target accounts in the database
        // accountRepository.save(sourceAccount);
        // accountRepository.save(targetAccount);
        return transaction;
    }
}
