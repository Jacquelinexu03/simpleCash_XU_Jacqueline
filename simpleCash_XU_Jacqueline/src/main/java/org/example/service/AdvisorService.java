package org.example.service;

import org.example.dto.AdvisorCreateDto;
import org.example.dto.AdvisorDto;
import org.example.dto.AdvisorUpdateDto;

import java.util.List;
import java.util.Optional;


public interface AdvisorService {
    List<AdvisorDto> findAll();
    AdvisorDto save(AdvisorCreateDto dto);
    Optional<AdvisorDto> findById(Long id);
    Optional<AdvisorDto> update(Long id, AdvisorUpdateDto dto);
    boolean deleteAdvisor(Long id);
}
