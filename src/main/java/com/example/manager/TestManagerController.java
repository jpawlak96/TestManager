package com.example.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TestManagerController {

    private final TestManagerService service;

    @GetMapping
    public List<TestDto> getAll() {
        log.debug("getAll();");
        return service.findAll();
    }

    @PostMapping
    public TestDto save(@Valid @RequestBody TestDto dto) {
        log.debug("save(); {}", dto);
        return service.save(dto);
    }

    @PostMapping(path = "{id}")
    public TestDto updateStatusById(@PathVariable Long id, @RequestParam TestStatus newStatus) {
        log.debug("updateStatusById(); id: {}, newStatus: {}", id, newStatus);
        return service.updateStatusById(id, newStatus);
    }
}
