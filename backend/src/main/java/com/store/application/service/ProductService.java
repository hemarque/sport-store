package com.store.application.service;

import com.store.application.dto.PartDTO;
import com.store.application.dto.ProductDTO;
import com.store.domain.model.Part;
import com.store.domain.model.Product;
import com.store.domain.repository.PartRepository;
import com.store.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final PartRepository partRepository;

    public ProductService(ProductRepository productRepository, PartRepository partRepository) {
        this.productRepository = productRepository;
        this.partRepository = partRepository;
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
    public ProductDTO save(ProductDTO productDTO) {
        List<Part> parts = new ArrayList<Part>();
        for(PartDTO part : productDTO.getParts()){
            parts.add(partRepository.findById(part.getId()));
        }

        Product product = new Product(
                productDTO.getId(),
                productDTO.getType(),
                productDTO.getName(),
                productDTO.getPrice(),
                parts);

        Product response = productRepository.save(product);
        return toDTO(response);
    }

    private ProductDTO toDTO(Product product) {
        List<PartDTO> parts = new ArrayList<PartDTO>();
        for(Part part : product.getParts()){
            parts.add(new PartDTO(null, part.getType(), part.getOption(), part.getPrice()));
        }
        return new ProductDTO(product.getId(), product.getType(), product.getName(), product.getBasePrice(), parts);
    }
}
