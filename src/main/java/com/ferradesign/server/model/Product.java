package com.ferradesign.server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    int id;
    String name;
    String description;
    Double price;
    Integer imageId;

    public Product(int id, String name, String description, Double price, Integer imageId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imageId='" + imageId +
                '}';
    }
}

