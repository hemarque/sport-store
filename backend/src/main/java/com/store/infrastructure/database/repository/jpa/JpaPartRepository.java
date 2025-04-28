package com.store.infrastructure.database.repository.jpa;

import com.store.infrastructure.database.entity.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPartRepository extends JpaRepository<PartEntity, Long> {
}