package org.example.mapper;

import org.example.dto.AccountCreateDto;
import org.example.dto.AccountDto;
import org.example.dto.AccountUpdateDto;
import org.example.entity.Account;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(Account account);

    @Mapping(target = "id", ignore = true)
    Account toEntity(AccountCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Account entity, AccountUpdateDto dto);
}

