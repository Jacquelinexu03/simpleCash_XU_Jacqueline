package org.example.dto;

public record ClientDto(
        String lastName,
        String firstName,
        String address,
        String postalCode,
        String city,
        String phoneNumber){
}
