package com.example.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin
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

    @PutMapping(path = "{id}")
    public TestDto updateStatusById(@PathVariable Long id, @RequestBody TestDto dto) {
        log.debug("updateStatusById(); id: {}, newStatus: {}", id, dto.getStatus());
        return service.updateStatusById(id, dto.getStatus());
    }
}
