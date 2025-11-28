package org.example.system;

import org.example.entity.Account;
import org.example.entity.Client;
import org.example.repository.AccountRepository;
import org.example.repository.ClientRepository;

import java.util.List;

public class SimpleCashSIImpl implements SimpleCashSI {
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;

    public SimpleCashSIImpl(ClientRepository clientRepository, AccountRepository accountRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Client createClient(String firstName, String lastName, String address, String postalCode, String city, String phone) {
        Client client = new Client(firstName, lastName, address, postalCode, city, phone);
        return clientRepository.save(client);
    }

    @Override
    public Account createAccount(Client client, boolean isChecking) {
        Account account = new Account(client, isChecking);
        return accountRepository.save(account);
    }

    @Override
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
        accountRepository.save(account);
    }

    @Override
    public List<Account> getAccountsByClient(Client client) {
        return accountRepository.findByClient(client);
    }
}
