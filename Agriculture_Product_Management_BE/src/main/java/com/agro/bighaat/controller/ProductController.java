package com.agro.bighaat.controller;

import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.ProductModel;
import com.agro.bighaat.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        Page<Product> products = productService.getAllProducts(pageable);
        return ResponseEntity.ok(products);
    }
    @PostMapping(value= "/products")
    public ResponseEntity<Product> createProduct(@ModelAttribute ProductModel productModel) {
        Product product = productService.createProduct(productModel);
        return ResponseEntity.ok(product);
    }
}
