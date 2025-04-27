package com.store.application.dto;

import java.util.List;

public class ProductDTO {
    private Long id;
    private String type;
    private String name;
    private Float price;
    private List<PartDTO> parts;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String type, String name, Float price, List<PartDTO> parts) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<PartDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartDTO> parts) {
        this.parts = parts;
    }
}
