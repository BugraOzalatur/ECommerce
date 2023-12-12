package com.bulutmd.ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class ProductImage {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] imageData;

    public ProductImage(byte[] imageData) {
        this.imageData = imageData;
    }

    public ProductImage() {

    }
}
