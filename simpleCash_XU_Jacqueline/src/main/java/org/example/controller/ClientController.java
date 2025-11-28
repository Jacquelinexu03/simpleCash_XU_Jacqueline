package org.example.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.ClientCreateDto;
import org.example.dto.ClientDto;
import org.example.dto.ClientUpdateDto;
import org.example.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/client")
@RequiredArgsConstructor
public class ClientController {
    public final ClientService clientService;

    @GetMapping
    List<ClientDto> getClients() {
        return this.clientService.findAll();
    }

    @PostMapping
    ClientDto save(@RequestBody @Valid ClientCreateDto Client) {
        return this.clientService.save(Client);
    }

    @GetMapping("{id}")
    ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return clientService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody @Valid ClientUpdateDto dto) {
        return clientService.update(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    ResponseEntity<ClientDto> deleteClient(@PathVariable Long id) {
        boolean deleted = clientService.deleteClient(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }    }
}
