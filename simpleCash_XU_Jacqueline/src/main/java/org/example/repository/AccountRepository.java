package org.example.repository;

import org.example.entity.Account;
import org.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByClient(Client client);
}
