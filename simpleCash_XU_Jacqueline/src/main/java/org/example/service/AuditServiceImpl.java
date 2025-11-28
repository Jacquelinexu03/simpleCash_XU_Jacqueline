package org.example.service;

import org.example.entity.Account;
import org.example.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuditServiceImpl implements AuditService {
    private final AccountRepository accountRepository;

    public AuditServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void analyseAll() {
        List<Account> accounts = accountRepository.findAll();
        int count = 0;
        for (Account account : accounts) {
            if (overdrawn(account)) {
                count += 1;
            }
        }
        if (count > 0) {
            System.out.println("There are " + count + " accounts overdrawn!");
        } else {
            System.out.println("No overdrawn accounts!");
        }
    }

    @Override
    public boolean overdrawn(Account account) {
        System.out.println("Account ID: " + account.getId());
        System.out.println("Client: " + account.getClient().getFirstName() + " " + account.getClient().getLastName());
        System.out.println("Balance: " + account.getBalance());

        if (account.getBalance() < 1000) {
            System.out.println("Warning: Account overdrawn!");
            return true;
        }
        return false;
    }
}
