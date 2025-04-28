package com.store.infrastructure.controller;

import com.store.application.dto.ProductDTO;
import com.store.application.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return this.service.findProductById(id);
    }

}
