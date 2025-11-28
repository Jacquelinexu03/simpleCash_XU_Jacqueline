package org.example.system;

import org.example.entity.Account;
import org.example.entity.Client;
import java.util.List;

public interface SimpleCashSI {
    Client createClient(String firstName, String lastName, String address, String postalCode, String city, String phone);
    Account createAccount(Client client, boolean isChecking);
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    List<Account> getAccountsByClient(Client client);
}
