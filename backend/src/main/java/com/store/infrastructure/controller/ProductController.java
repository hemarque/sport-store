package com.store.infrastructure.controller;

import com.store.application.dto.PartDTO;
import com.store.application.dto.ProductDTO;
import com.store.application.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO product) {
        System.out.println(product.getName());
        for(PartDTO part : product.getParts()){
            System.out.println("   " + part.getOption());
        }
        return service.save(product);
    }
}
