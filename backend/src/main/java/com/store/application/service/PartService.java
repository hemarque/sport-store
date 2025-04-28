package com.store.application.service;

import com.store.application.dto.PartDTO;
import com.store.domain.model.Part;
import com.store.domain.repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartService {
    private final PartRepository repository;

    public PartService(PartRepository repository) {
        this.repository = repository;
    }

    public List<PartDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private PartDTO toDTO(Part part) {
        return new PartDTO(part.getId(), part.getType(), part.getOption(), part.getPrice());
    }
}
