package org.example.dto;

import org.example.entity.Client;

public record AccountDto(
    Client client,
    boolean isChecking,
    double balance) {
}
