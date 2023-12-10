package com.bulutmd.ProductService.DTO;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data

public class ProductDTO {
private String name;
private double price;
private int stock;
    public ProductDTO(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;

    }
}
