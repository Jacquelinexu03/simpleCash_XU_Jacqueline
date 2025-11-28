package org.example.service;

import org.example.dto.AccountDto;
import org.example.dto.AccountCreateDto;
import org.example.dto.AccountUpdateDto;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<AccountDto> findAll();
    AccountDto save(AccountCreateDto dto);
    Optional<AccountDto> findById(Long id);
    Optional<AccountDto> update(Long id, AccountUpdateDto dto);
    boolean deleteAccount(Long id);
}
