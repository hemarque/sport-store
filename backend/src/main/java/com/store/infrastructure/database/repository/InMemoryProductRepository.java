package com.store.infrastructure.database.repository;

import com.store.domain.model.Part;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private Long partIdIndex = 1L;

    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(
                    partIdIndex++,
                    "bicycle",
                    "Mountain Bike",
                    303f,
                    new ArrayList<>(Arrays.asList(
                            new Part(1L, "Frame Type", "Full-suspension", 130f),
                            new Part(2L, "Frame Finish", "Shiny", 30f),
                            new Part(3L, "Wheels", "Mountain wheels", 80f),
                            new Part(4L, "Rim Color", "Black", 20f),
                            new Part(5L, "Chain", "Single-speed chain", 43f)
                    ))
            ),
            new Product(
                    partIdIndex++,
                    "bicycle",
                    "Road Bike",
                    285f,
                    new ArrayList<>(Arrays.asList(
                            new Part(6L, "Frame Type", "Diamond", 120f),
                            new Part(7L, "Frame Finish", "Matte", 25f),
                            new Part(8L, "Wheels", "Road wheels", 70f),
                            new Part(9L, "Rim Color", "Blue", 20f),
                            new Part(10L, "Chain", "8-speed chain", 50f)
                    ))
            ),
            new Product(
                    partIdIndex++,
                    "bicycle",
                    "Fat Bike",
                    318f,
                    new ArrayList<>(Arrays.asList(
                            new Part(11L, "Frame Type", "Full-suspension", 130f),
                            new Part(12L, "Frame Finish", "Matte", 25f),
                            new Part(13L, "Wheels", "Fat bike wheels", 100f),
                            new Part(14L, "Rim Color", "Black", 20f),
                            new Part(15L, "Chain", "Single-speed chain", 43f)
                    ))
            )
    ));

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public Product save(Product product) {
        product.setId(partIdIndex++);
        products.add(product);
        return product;
    }
}
