package com.example.TestManager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TestEntityController {

    private final TestEntityRepository repository;

    @GetMapping
    public List<TestEntity> getAll() {
        return repository.findAll();
    }

    @GetMapping(path = "{id}")
    public TestEntity getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
