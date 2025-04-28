package com.store.infrastructure.database.repository;

import com.store.domain.model.Part;
import com.store.domain.repository.PartRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class InMemoryPartRepository implements PartRepository {
    private final List<Part> parts = Arrays.asList(
            new Part(1L, "Frame Type", "Full-suspension", 130f),
            new Part(2L, "Frame Finish", "Shiny", 30f),
            new Part(3L, "Wheels", "Mountain wheels", 80f),
            new Part(4L, "Rim Color", "Black", 20f),
            new Part(5L, "Chain", "Single-speed chain", 43f)
    );

    @Override
    public List<Part> findAll() {
        return parts;
    }
}
