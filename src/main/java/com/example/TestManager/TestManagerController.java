package com.example.TestManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TestEntityController {

    private final TestEntityService service;

    @GetMapping
    public List<TestDto> getAll() {
        log.info("getAll();");
        return service.findAll();
    }

    @PostMapping
    public TestDto save(@Valid TestDto dto) {
        log.info("save(); {}", dto);
        if (dto.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return service.save(dto);
    }

    @PostMapping(path = "{id}")
    public TestDto updateById(@PathVariable Long id, @RequestParam TestStatus newStatus) {
        log.info("updateById(); id: {}, newStatus: {}", id, newStatus);
        return service.updateById(id, newStatus);
    }
}
