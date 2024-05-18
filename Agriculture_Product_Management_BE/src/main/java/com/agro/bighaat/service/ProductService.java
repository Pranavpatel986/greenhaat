package com.agro.bighaat.service;

import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);

    Product createProduct(ProductModel productModel) ;
}
