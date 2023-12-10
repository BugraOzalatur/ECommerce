package com.bulutmd.ProductService.service;

import com.bulutmd.ProductService.DTO.ProductDTO;
import com.bulutmd.ProductService.model.Product;
import com.bulutmd.ProductService.model.ProductImage;
import com.bulutmd.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public ResponseEntity<List<Product>> listAllProduct() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<Product> listProductById(Long id) {
        return ResponseEntity.ok(productRepository.getReferenceById(id));
    }

    public ResponseEntity<Product> addProduct(ProductDTO productDto) {


        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        if (productDto.getImages() != null && !productDto.getImages().isEmpty()) {
            List<ProductImage> productImages = productDto.getImages().stream()
                    .map(image -> {
                        try {
                            return new ProductImage(image.getBytes());
                        } catch (IOException e) {
                            throw new RuntimeException("Error converting image to byte array", e);
                        }
                    }).collect(Collectors.toList());
            product.setImages(productImages);
        }
        return ResponseEntity.ok(productRepository.save(product));
    }


    public ResponseEntity updateProduct(Long id, ProductDTO productDTO) {
        Product product = new Product();
        product = productRepository.getReferenceById(id);
        if (product != null) {
            product.setStock(productDTO.getStock());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            if (productDTO.getImages() != null && !productDTO.getImages().isEmpty()) {
                List<ProductImage> productImages = productDTO.getImages().stream()
                        .map(image -> {
                            try {
                                return new ProductImage(image.getBytes());
                            } catch (IOException e) {
                                throw new RuntimeException("Error converting image to byte array", e);
                            }
                        })
                        .collect(Collectors.toList());

                product.setImages(productImages);
            }

            return ResponseEntity.ok(productRepository.save(product));
        }

        return ResponseEntity.status(404).body("Product not found.");
    }

    public ResponseEntity deleteProduct(Long id) {
        Product product = new Product();
        product = productRepository.getReferenceById(id);
        productRepository.delete(product);
        if (product != null) {
            return ResponseEntity.ok("işlem başarıyla gerçekleştirildi");
        }
        return ResponseEntity.ok("işlem başarısızlık ile gerçekleştirilemedi");
    }


}
