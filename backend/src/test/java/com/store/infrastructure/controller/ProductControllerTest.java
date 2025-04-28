package com.store.infrastructure.controller;

import com.store.application.dto.ProductDTO;
import com.store.application.service.ProductService;
import com.store.domain.repository.ProductRepository;
import com.store.infrastructure.database.repository.InMemoryProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}
