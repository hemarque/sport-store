package com.store.domain.model;

import java.util.List;

public class Product {
    private Long id;
    private String type;
    private String name;
    private Float basePrice;
    private List<Part> parts;

    public Product(Long id, String type, String name, Float basePrice, List<Part> parts) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.parts = parts;
        this.basePrice = basePrice;
        this.updatePrice();
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

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
        this.updatePrice();
    }

    private void updatePrice() {
        Float price = 0f;
        for (Part part : this.parts) {
            price += part.getPrice();
        }
        this.basePrice = price;
    }

}
