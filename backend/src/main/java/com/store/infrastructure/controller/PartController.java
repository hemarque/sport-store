package com.store.infrastructure.controller;

import com.store.application.dto.PartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    private final List<PartDTO> parts = new ArrayList<>();

    public PartController() {
        // not yet implemented
        parts.add(new PartDTO(1L, "Frame Type", "Diamond", 120f));
        parts.add(new PartDTO(2L, "Wheels", "Mountain wheels", 80f));
    }

    @GetMapping
    public List<PartDTO> getParts() {
        // not yet implemented
        return parts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PartDTO createPart(@RequestBody PartDTO newPart) {
        // not yet implemented
        parts.add(newPart);
        return newPart;
    }
}
