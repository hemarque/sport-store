package com.store.infrastructure.database.repository;

import com.store.domain.model.Part;
import com.store.domain.repository.PartRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryPartRepository implements PartRepository {
    private Long partIdIndex = 1L;
    private List<Part> parts = new ArrayList<>(Arrays.asList(
            new Part(partIdIndex++, "Frame Type", "Full-suspension", 130f),
            new Part(partIdIndex++, "Frame Finish", "Shiny", 30f),
            new Part(partIdIndex++, "Wheels", "Mountain wheels", 80f),
            new Part(partIdIndex++, "Rim Color", "Black", 20f),
            new Part(partIdIndex++, "Chain", "Single-speed chain", 43f)
    ));

    @Override
    public List<Part> findAll() {
        return parts;
    }

    @Override
    public Part findById(Long id) {
        Part response = null;
        for (Part part : parts) {
            if (part.getId().equals(id)) {
                response = part;
                break;
            }
        }
        return response;
    }

    @Override
    public Part save(Part part) {
        part.setId(partIdIndex++);
        this.parts.add(part);
        return part;
    }
}
