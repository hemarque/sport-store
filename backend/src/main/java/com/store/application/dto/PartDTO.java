package com.store.application.dto;

public class PartDTO {
    private String type;
    private String option;
    private Float price;

    public PartDTO() {
    }

    public PartDTO(String type, String option, Float price) {
        this.type = type;
        this.option = option;
        this.price = price;
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
