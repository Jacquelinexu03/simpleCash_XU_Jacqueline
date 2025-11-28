package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.entity.Client;

import java.util.List;

public record AdvisorUpdateDto(
        @NotBlank(message = "FisrtName cannot be empty")
        String firstName,
        @NotBlank(message = "FisrtName cannot be empty")
        String lastName,
        List<Client> clients) {
}