package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.AccountCreateDto;
import org.example.dto.AccountDto;
import org.example.dto.AccountUpdateDto;
import org.example.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

    @GetMapping
    List<AccountDto> getAccounts() {
        return this.accountService.findAll();
    }

    @PostMapping
    AccountDto save(@RequestBody @Valid AccountCreateDto Account) {
        return this.accountService.save(Account);
    }

    @GetMapping("{id}")
    ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
        return accountService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody @Valid AccountUpdateDto dto) {
        return accountService.update(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    ResponseEntity<AccountDto> deleteAccount(@PathVariable Long id) {
        boolean deleted = accountService.deleteAccount(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}