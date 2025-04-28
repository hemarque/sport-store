package com.store.domain.repository;

import com.store.application.dto.PartDTO;
import com.store.domain.model.Part;

import java.util.List;

public interface PartRepository {
    List<Part> findAll();

    Part save(Part part);
}
