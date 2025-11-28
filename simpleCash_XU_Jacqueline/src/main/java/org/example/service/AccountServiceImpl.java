package org.example.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.dto.AccountCreateDto;
import org.example.dto.AccountDto;
import org.example.dto.AccountUpdateDto;
import org.example.entity.Account;
import org.example.mapper.AccountMapper;
import org.example.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final AccountMapper accountMapper;

    /*
    @PostConstruct
    private void initdb() {
        repository.saveAll(List.of(
                new Account(),
                new Account(),
                new Account()
        ));
    }
    */

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll().stream().map(accountMapper::toDto).toList();
    }

    @Override
    public AccountDto save(AccountCreateDto account) {
        Account entity = accountMapper.toEntity(account);
        Account saved = repository.save(entity);
        return accountMapper.toDto(saved);
    }

    @Override
    public Optional<AccountDto> findById(Long id) {
        return repository.findById(id).map(accountMapper::toDto);
    }

    @Transactional
    @Override
    public Optional<AccountDto> update(Long id, AccountUpdateDto dto) {
        return repository.findById(id).map(account -> {
            accountMapper.updateEntity(account, dto);
            return accountMapper.toDto(account);
        });
    }

    @Override
    public boolean deleteAccount(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
