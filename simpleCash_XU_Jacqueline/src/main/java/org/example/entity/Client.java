package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    private String address;

    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;

    private String city;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    public Client(String lastName, String firstName, String address, String postalCode, String city, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phone;
    }

    public void updateFirstName(String name) {
        this.firstName = name;
    }

    public void updateLastName(String name) {
        this.lastName = name;
    }

    public void updatePostalCode(String code) {
        this.postalCode = code;
    }

    public void updateCity(String city) {
        this.city = city;
    }

    public void updatePhoneNumber(String name) {
        this.phoneNumber = name;
    }
}

