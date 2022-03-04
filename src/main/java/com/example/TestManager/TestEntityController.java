package com.example.TestManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TestEntityController {

    private final TestEntityService service;

    @GetMapping
    public List<TestEntity> getAll() {
        log.info("getAll()");
        return service.findAll();
    }

    @PostMapping
    public TestEntity save(TestEntity entity) {
        log.info("save()");
        return service.save(entity);
    }

    @PostMapping(path = "{id}")
    public TestEntity updateById(@PathVariable Long id, @RequestParam TestStatus newStatus) {
        log.info("updateById()");
        return service.updateById(id, newStatus);
    }
}
