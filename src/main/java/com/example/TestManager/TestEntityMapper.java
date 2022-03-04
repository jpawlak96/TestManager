package com.example.TestManager;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestEntityMapper {

    TestEntity toEntity(TestDto dto);

    TestDto toDto(TestEntity dto);
}
