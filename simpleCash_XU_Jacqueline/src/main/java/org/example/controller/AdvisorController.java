package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.AdvisorCreateDto;
import org.example.dto.AdvisorDto;
import org.example.dto.AdvisorUpdateDto;
import org.example.service.AdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/advisor")
@RequiredArgsConstructor
public class AdvisorController {
    public final AdvisorService advisorService;

    @GetMapping
    List<AdvisorDto> getAdvisors() {
        return this.advisorService.findAll();
    }

    @PostMapping
    AdvisorDto save(@RequestBody @Valid AdvisorCreateDto Advisor) {
        return this.advisorService.save(Advisor);
    }

    @GetMapping("{id}")
    ResponseEntity<AdvisorDto> getAdvisor(@PathVariable Long id) {
        return advisorService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    ResponseEntity<AdvisorDto> updateAdvisor(@PathVariable Long id, @RequestBody @Valid AdvisorUpdateDto dto) {
        return advisorService.update(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    ResponseEntity<AdvisorDto> deleteAdvisor(@PathVariable Long id) {
        boolean deleted = advisorService.deleteAdvisor(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }    }
}
