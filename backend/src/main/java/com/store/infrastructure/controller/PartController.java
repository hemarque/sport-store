package com.store.infrastructure.controller;

import com.store.application.dto.PartDTO;
import com.store.application.service.PartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {


    private final PartService service;

    public PartController(PartService service) {
        this.service = service;
    }

    @GetMapping
    public List<PartDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PartDTO save(@RequestBody PartDTO part) {
        return service.save(part);
    }
}
