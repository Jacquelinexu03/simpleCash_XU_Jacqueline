package org.example.dto;

import org.example.entity.Client;

public record AccountCreateDto(
    Client client,
    boolean isChecking,
    double balance) {
}
