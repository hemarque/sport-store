package com.store.application.service;

import com.store.application.dto.PartDTO;
import com.store.application.dto.ProductDTO;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return toDTO(product);
    }

    private ProductDTO toDTO(Product product) {
        List<PartDTO> parts = product.getParts()
                .stream()
                .map(p -> new PartDTO(p.getType(), p.getOption(), p.getPrice()))
                .collect(Collectors.toList());
        return new ProductDTO(product.getId(), product.getType(), product.getName(), product.getBasePrice(), parts);
    }
}
