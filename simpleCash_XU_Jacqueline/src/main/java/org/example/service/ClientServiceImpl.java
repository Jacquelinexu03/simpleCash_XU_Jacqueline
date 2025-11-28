package org.example.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.dto.ClientCreateDto;
import org.example.dto.ClientDto;
import org.example.dto.ClientUpdateDto;
import org.example.entity.Client;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ClientMapper clientMapper;

    @PostConstruct
    private void initdb() {
        repository.saveAll(List.of(
            new Client("A", "test", "", "75000", "", "0987654321"),
            new Client("B", "test", "", "75000", "", "0987654321"),
            new Client("C", "test", "", "75000", "", "0987654321"),
            new Client("D", "ok", "", "75001", "", "0983454321"),
            new Client("E", "ok", "", "75002", "", "0987004321")
        ));
    }

    @Override
    public List<ClientDto> findAll() {
        return repository.findAll().stream().map(clientMapper::toDto).toList();
    }

    @Override
    public ClientDto save(ClientCreateDto client) {
        Client entity = clientMapper.toEntity(client);
        Client saved = repository.save(entity);
        return clientMapper.toDto(saved);
    }

    @Override
    public Optional<ClientDto> findById(Long id) {
        return repository.findById(id).map(clientMapper::toDto);
    }

    @Transactional
    @Override
    public Optional<ClientDto> update(Long id, ClientUpdateDto dto) {
        return repository.findById(id).map(client -> {
            clientMapper.updateEntity(client, dto);
            return clientMapper.toDto(client);
        });
    }

    @Override
    public boolean deleteClient(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
