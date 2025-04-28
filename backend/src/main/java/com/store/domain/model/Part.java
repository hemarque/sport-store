package com.store.domain.model;

public class Part {
    private String type;
    private String option;
    private Float price;
    private Long id;

    public Part(Long id, String type, String option, Float price) {
        this.id = id;
        this.type = type;
        this.option = option;
        this.price = price;
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
