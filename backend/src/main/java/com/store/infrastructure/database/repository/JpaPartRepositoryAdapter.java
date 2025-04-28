package com.store.infrastructure.database.repository;

import com.store.domain.model.Part;
import com.store.domain.repository.PartRepository;
import com.store.infrastructure.database.entity.PartEntity;
import com.store.infrastructure.database.repository.jpa.JpaPartRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    private Part toDomain(PartEntity entity) {
        return new Part(entity.getId(), entity.getType(), entity.getOptionName(), entity.getPrice());
    }
}
