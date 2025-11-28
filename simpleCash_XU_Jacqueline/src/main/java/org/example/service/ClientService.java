package org.example.service;

import org.example.dto.ClientCreateDto;
import org.example.dto.ClientDto;
import org.example.dto.ClientUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientDto> findAll();
    ClientDto save(ClientCreateDto dto);
    Optional<ClientDto> findById(Long id);
    Optional<ClientDto> update(Long id, ClientUpdateDto dto);
    boolean deleteClient(Long id);
}
