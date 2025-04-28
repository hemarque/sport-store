package com.store.infrastructure.controller;

import com.store.application.dto.PartDTO;
import com.store.application.dto.ProductDTO;
import com.store.application.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<ProductDTO> mockProducts;

    {
        mockProducts = Arrays.asList(
                new ProductDTO(
                        1L,
                        "bicycle",
                        "Mountain Bike",
                        303f,
                        Arrays.asList(
                                new PartDTO("Frame Type", "Full-suspension", 130f),
                                new PartDTO("Frame Finish", "Shiny", 30f),
                                new PartDTO("Wheels", "Mountain wheels", 80f),
                                new PartDTO("Rim Color", "Black", 20f),
                                new PartDTO("Chain", "Single-speed chain", 43f)
                        )
                ),
                new ProductDTO(
                        2L,
                        "bicycle",
                        "Road Bike",
                        285f,
                        Arrays.asList(
                                new PartDTO("Frame Type", "Diamond", 120f),
                                new PartDTO("Frame Finish", "Matte", 25f),
                                new PartDTO("Wheels", "Road wheels", 70f),
                                new PartDTO("Rim Color", "Blue", 20f),
                                new PartDTO("Chain", "8-speed chain", 50f)
                        )
                ),
                new ProductDTO(
                        3L,
                        "bicycle",
                        "Fat Bike",
                        318f,
                        Arrays.asList(
                                new PartDTO("Frame Type", "Full-suspension", 130f),
                                new PartDTO("Frame Finish", "Matte", 25f),
                                new PartDTO("Wheels", "Fat bike wheels", 100f),
                                new PartDTO("Rim Color", "Black", 20f),
                                new PartDTO("Chain", "Single-speed chain", 43f)
                        )
                )
        );
    }

    public ProductController(ProductService service) {
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return this.mockProducts;
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return mockProducts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product not found with id: " + id
                ));
    }

}
