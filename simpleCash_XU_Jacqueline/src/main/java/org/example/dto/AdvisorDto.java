package org.example.dto;

import org.example.entity.Client;

import java.util.List;

public record AdvisorDto(
    String firstName,
    String lastName,
    List<Client> clients
) {
}
