package com.example.TestManager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestEntityService {

    private final TestEntityRepository repository;

    public List<TestEntity> findAll() {
        return repository.findAll();
    }

    public TestEntity save(TestEntity entity) {
        return repository.save(entity);
    }

    public TestEntity updateById(Long id, TestStatus newStatus) {
        TestEntity target = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        target.setStatus(newStatus);
        return repository.save(target);
    }
}
