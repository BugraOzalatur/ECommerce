package com.bulutmd.ProductService.controller;

import com.bulutmd.ProductService.DTO.ProductDTO;
import com.bulutmd.ProductService.model.Product;
import com.bulutmd.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProduct() {
        return productService.listAllProduct();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }
    @GetMapping("/list")
    public ResponseEntity<Product> listProductById(@RequestParam("id") Long id){
        return productService.listProductById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity updateProduct(@RequestParam("id") Long id,@RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }

}
