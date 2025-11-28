package org.example.dto;

import org.example.entity.Client;

public record AccountUpdateDto(
    Client client,
    boolean isChecking,
    double balance) {
}
