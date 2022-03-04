package com.example.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestManagerService {

    private final TestEntityRepository repository;
    private final TestEntityMapper mapper;

    public List<TestDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public TestDto save(TestDto dto) {
        TestEntity entity = mapper.toEntity(dto);
        TestEntity savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    public TestDto updateStatusById(Long id, TestStatus newStatus) {
        TestEntity target = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        target.setStatus(newStatus);
        TestEntity entity = repository.save(target);
        return mapper.toDto(entity);
    }
}
