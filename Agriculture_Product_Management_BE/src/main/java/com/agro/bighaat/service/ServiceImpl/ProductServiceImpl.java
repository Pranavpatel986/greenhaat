package com.agro.bighaat.service.ServiceImpl;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.ProductModel;
import com.agro.bighaat.repository.BrandRepository;
import com.agro.bighaat.repository.ProductRepository;
import com.agro.bighaat.service.BrandService;
import com.agro.bighaat.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    @Override
    public Product createProduct(ProductModel productModel){
        String productName = productModel.getProductName();
        String technicalName = productModel.getTechnicalName();

        Product existingProduct = productRepository.findByProductNameAndTechnicalName(productName, technicalName);
        if (existingProduct != null) {
            // Product with the given name and technical name already exists, update it
            BeanUtils.copyProperties(productModel, existingProduct);
            productRepository.save(existingProduct);
            return existingProduct; // Return the updated product
        }

        Product product = new Product();

        Brand brand= brandRepository.findBrandById(productModel.getBrandId());

        product.setProductName(productModel.getProductName());
        product.setTechnicalName(productModel.getTechnicalName());
        product.setDescription(productModel.getDescription());
        product.setBrand(brand);
//        product.setImage(image.getBytes());
        product.setMrp(productModel.getMrp());
        product.setProductType(productModel.getProductType());
        product.setEnable(productModel.isEnable());

        // Handle image upload
        try {
            product.setImage(productModel.getImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image: " + e.getMessage());
        }

        Product savedProduct = productRepository.save(product);
        return savedProduct; // Return the newly saved product
    }

}
