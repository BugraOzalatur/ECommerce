package com.bulutmd.ProductService.controller;

import com.bulutmd.ProductService.DTO.ProductDTO;
import com.bulutmd.ProductService.model.Product;
import com.bulutmd.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProduct() {
        return productService.listAllProduct();
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO,@RequestPart("image") List<MultipartFile> image){
        return productService.addProduct(productDTO,image);
    }

    @GetMapping("/getlist")
    public ResponseEntity<Product> listProductById(@RequestBody Long id){
        return productService.listProductById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity updateProduct(@RequestParam("id") Long id,@RequestBody ProductDTO productDTO,@RequestPart("image") List<MultipartFile> images){
        return productService.updateProduct(id,productDTO,images);
    }
@DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam("id") Long id){
        return productService.deleteProduct(id);
}
}
