package com.store.infrastructure.database.repository.jpa;

import com.store.infrastructure.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
