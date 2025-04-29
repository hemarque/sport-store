package com.store.infrastructure.controller;

import com.store.application.dto.PartDTO;
import com.store.application.dto.ProductDTO;
import com.store.application.service.ProductService;
import com.store.domain.repository.PartRepository;
import com.store.domain.repository.ProductRepository;
import com.store.infrastructure.database.repository.InMemoryPartRepository;
import com.store.infrastructure.database.repository.InMemoryProductRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductControllerTest {
    @Test
    public void shouldGetAllProducts(){
        ProductRepository productRepository = new InMemoryProductRepository();
        PartRepository partRepository = new InMemoryPartRepository();
        ProductService service = new ProductService(productRepository, partRepository);
        ProductController controller = new ProductController(service);

        List products = controller.findAll();

        assertEquals(3, products.size());
    }

    @Test
    public void shouldFindProductById(){
        ProductRepository productRepository = new InMemoryProductRepository();
        PartRepository partRepository = new InMemoryPartRepository();
        ProductService service = new ProductService(productRepository, partRepository);
        ProductController controller = new ProductController(service);

        ProductDTO product = controller.findProductById(1L);

        assertEquals(1L, product.getId());
        assertEquals("Mountain Bike", product.getName());
    }

    @Test
    public void shouldSaveProduct(){
        ProductRepository productRepository = new InMemoryProductRepository();
        PartRepository partRepository = new InMemoryPartRepository();
        ProductService service = new ProductService(productRepository, partRepository);
        ProductController controller = new ProductController(service);
        ProductDTO product = new ProductDTO(
                null,
                "Bicycle",
                "Island Bike",
                318f,
                new ArrayList<>(Arrays.asList(
                        new PartDTO(1L, "Frame Type", "Full-suspension", 130f),
                        new PartDTO(2L, "Frame Finish", "Shiny", 25f),
                        new PartDTO(3L, "Wheels", "Mountain wheels", 100f),
                        new PartDTO(4L, "Rim Color", "Black", 20f),
                        new PartDTO(5L, "Chain", "Single-speed chain", 43f)
                ))
        );

        ProductDTO response = controller.save(product);

        assertNotNull(response.getId());
        assertEquals("Island Bike", response.getName());
    }
}
