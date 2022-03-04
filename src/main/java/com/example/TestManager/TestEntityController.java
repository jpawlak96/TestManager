package com.example.TestManager;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TestEntityController {

    private final TestEntityService service;

    @GetMapping
    public List<TestEntity> getAll() {
        return service.findAll();
    }

    @PostMapping
    public TestEntity save(TestEntity entity) {
        return service.save(entity);
    }

    @PostMapping(path = "{id}")
    public TestEntity updateById(@PathVariable Long id, @RequestParam TestStatus newStatus) {
        return service.updateById(id, newStatus);
    }
}
