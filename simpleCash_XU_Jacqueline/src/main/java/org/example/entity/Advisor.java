package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "FirstName cannot be empty")
    private String firstName;

    @NotBlank(message = "LastName cannot be empty")
    private String lastName;

    @OneToMany(mappedBy = "advisor")
    private List<Client> clients;

    public Advisor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void assignClient(Client client) {
        clients.add(client);
        client.setAdvisor(this);
    }
}
