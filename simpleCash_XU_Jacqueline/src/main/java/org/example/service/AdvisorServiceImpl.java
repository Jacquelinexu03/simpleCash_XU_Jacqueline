package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.AdvisorCreateDto;
import org.example.dto.AdvisorDto;
import org.example.dto.AdvisorUpdateDto;
import org.example.entity.Advisor;
import org.example.mapper.AdvisorMapper;
import org.example.repository.AdvisorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {
    private final AdvisorRepository repository;
    private final AdvisorMapper advisorMapper;

    @Override
    public List<AdvisorDto> findAll() {
        return repository.findAll().stream().map(advisorMapper::toDto).toList();
    }

    @Override
    public AdvisorDto save(AdvisorCreateDto advisor) {
        Advisor entity = advisorMapper.toEntity(advisor);
        Advisor saved = repository.save(entity);
        return advisorMapper.toDto(saved);
    }

    @Override
    public Optional<AdvisorDto> findById(Long id) {
        return repository.findById(id).map(advisorMapper::toDto);
    }

    @Transactional
    @Override
    public Optional<AdvisorDto> update(Long id, AdvisorUpdateDto dto) {
        return repository.findById(id).map(advisor -> {
            advisorMapper.updateEntity(advisor, dto);
            return advisorMapper.toDto(advisor);
        });
    }

    @Override
    public boolean deleteAdvisor(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
