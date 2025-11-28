package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.BankApplication;
import org.example.dto.ClientDto;
import org.example.entity.Client;
import org.example.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BankApplication.class)
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRepository repo;

    @BeforeEach
    void setup() {
        repo.deleteAll();
    }

    @Test
    void testCreateClient() throws Exception {
        ClientDto dto = new ClientDto("Durand", "Paul", "1 rue test", "75000", "Paris", "0600000000");
        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.lastName").value("Martin"))
                .andExpect(jsonPath("$.firstName").value("Laura"));

    }

    @Test
    void testGetClientById() throws Exception {
        Client c = new Client("Martin", "Laura", "2 avenue test", "69000", "Lyon", "0700000000");
        repo.save(c);

        mockMvc.perform(get("/client/" + c.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Martin"));
    }
}
