package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "advisor")
    private Advisor advisor;

    public Client(String lastName, String firstName, String address, String postalCode, String city, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phone;

        this.accounts.add(new Account(this, true));
        this.accounts.add(new Account(this, false));
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

