package com.store.infrastructure.database.repository;

import com.store.domain.model.Part;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import com.store.infrastructure.database.entity.PartEntity;
import com.store.infrastructure.database.entity.ProductEntity;
import com.store.infrastructure.database.repository.jpa.JpaProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class JpaProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id)
                .map(this::toDomain);
    }

    private Product toDomain(ProductEntity entity) {
        List<Part> parts = entity.getParts().stream()
                .map(p -> new Part(p.getId(), p.getType(), p.getOptionName(), p.getPrice()))
                .collect(Collectors.toList());
        return new Product(entity.getId(), entity.getType(), entity.getName(), entity.getPrice(), parts);
    }
}
