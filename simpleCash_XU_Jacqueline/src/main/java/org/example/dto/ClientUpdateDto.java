package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientUpdateDto(
    String lastName,
    @NotBlank(message = "First name cannot be empty")
    String firstName,
    String address,
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    String postalCode,
    String city,
    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    String phoneNumber){
}
