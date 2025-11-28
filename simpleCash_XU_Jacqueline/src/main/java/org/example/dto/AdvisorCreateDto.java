package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.entity.Client;

import java.util.List;

public record AdvisorCreateDto(
    @NotBlank(message = "FirstName cannot be empty")
    String firstName,
    @NotBlank(message = "LastName cannot be empty")
    String lastName,
    List<Client> clients) {
}
