package com.store.infrastructure.database.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    public ProductEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private Float price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PartEntity> parts;

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

    public List<PartEntity> getParts() {
        return parts;
    }

    public void setParts(List<PartEntity> parts) {
        this.parts = parts;
    }
}
