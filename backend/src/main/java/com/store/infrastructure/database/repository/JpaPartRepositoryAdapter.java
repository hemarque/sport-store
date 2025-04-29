package com.store.infrastructure.database.repository;

import com.store.domain.model.Part;
import com.store.domain.repository.PartRepository;
import com.store.infrastructure.database.entity.PartEntity;
import com.store.infrastructure.database.repository.jpa.JpaPartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class JpaPartRepositoryAdapter implements PartRepository {
    private final JpaPartRepository jpaPartRepository;

    public JpaPartRepositoryAdapter(JpaPartRepository jpaPartRepository) {
        this.jpaPartRepository = jpaPartRepository;
    }

    @Override
    public List<Part> findAll() {
        return jpaPartRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Part findById(Long id) {
        return jpaPartRepository.findById(id)
                .map(this::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Part not found with id " + id));
    }

    @Override
    public Part save(Part part) {
        PartEntity entity = toEntity(part);
        PartEntity savedEntity = jpaPartRepository.save(entity);
        return toDomain(savedEntity);
    }

    private PartEntity toEntity(Part part) {
        PartEntity entity = new PartEntity();
        entity.setId(part.getId());
        entity.setType(part.getType());
        entity.setOptionName(part.getOption());
        entity.setPrice(part.getPrice());
        return entity;
    }

    private Part toDomain(PartEntity entity) {
        return new Part(entity.getId(), entity.getType(), entity.getOptionName(), entity.getPrice());
    }
}
