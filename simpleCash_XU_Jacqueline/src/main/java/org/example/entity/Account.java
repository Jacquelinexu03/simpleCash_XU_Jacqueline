package org.example.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private boolean checking = true;
    private double balance = 0.0;

    public Account(Client client, boolean isChecking) {
        this.client = client;
        this.checking = isChecking;
    }

    public void deposit(double amount) {
        // TODO : exception negative
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
