package com.store.infrastructure.controller;

import com.store.application.dto.ProductDTO;
import com.store.application.service.ProductService;
import com.store.domain.model.Part;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest {
    @Test
    public void shouldGetAllProducts(){
        ProductRepository repository = new InMemoryProductRepository();
        ProductService service = new ProductService(repository);
        ProductController controller = new ProductController(service);

        List products = controller.findAll();

        assertEquals(3, products.size());
    }

    @Test
    public void shouldFindProductById(){
        ProductRepository repository = new InMemoryProductRepository();
        ProductService service = new ProductService(repository);
        ProductController controller = new ProductController(service);

        ProductDTO product = controller.findProductById(1L);

        assertEquals(1L, product.getId());
        assertEquals("Mountain Bike", product.getName());
    }

    private class InMemoryProductRepository implements ProductRepository {

        private final List<Product> products = Arrays.asList(
                new Product(
                        1L,
                        "bicycle",
                        "Mountain Bike",
                        303f,
                        Arrays.asList(
                                new Part(1L, "Frame Type", "Full-suspension", 130f),
                                new Part(2L, "Frame Finish", "Shiny", 30f),
                                new Part(3L, "Wheels", "Mountain wheels", 80f),
                                new Part(4L, "Rim Color", "Black", 20f),
                                new Part(5L, "Chain", "Single-speed chain", 43f)
                        )
                ),
                new Product(
                        2L,
                        "bicycle",
                        "Road Bike",
                        285f,
                        Arrays.asList(
                                new Part(6L, "Frame Type", "Diamond", 120f),
                                new Part(7L, "Frame Finish", "Matte", 25f),
                                new Part(8L, "Wheels", "Road wheels", 70f),
                                new Part(9L, "Rim Color", "Blue", 20f),
                                new Part(10L, "Chain", "8-speed chain", 50f)
                        )
                ),
                new Product(
                        3L,
                        "bicycle",
                        "Fat Bike",
                        318f,
                        Arrays.asList(
                                new Part(11L, "Frame Type", "Full-suspension", 130f),
                                new Part(12L, "Frame Finish", "Matte", 25f),
                                new Part(13L, "Wheels", "Fat bike wheels", 100f),
                                new Part(14L, "Rim Color", "Black", 20f),
                                new Part(15L, "Chain", "Single-speed chain", 43f)
                        )
                )
        );

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
    }
}
