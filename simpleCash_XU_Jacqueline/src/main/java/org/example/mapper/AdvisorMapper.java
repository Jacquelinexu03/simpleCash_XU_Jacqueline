package org.example.mapper;

import org.example.dto.AdvisorCreateDto;
import org.example.dto.AdvisorDto;
import org.example.dto.AdvisorUpdateDto;
import org.example.entity.Advisor;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AdvisorMapper {
    AdvisorDto toDto(Advisor advisor);

    @Mapping(target = "id", ignore = true)
    Advisor toEntity(AdvisorCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Advisor entity, AdvisorUpdateDto dto);
}

