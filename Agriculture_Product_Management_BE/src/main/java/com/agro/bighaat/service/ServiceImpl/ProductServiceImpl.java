package com.agro.bighaat.service.ServiceImpl;

import com.agro.bighaat.entity.*;
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
import java.util.List;

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
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByProductNameContainingIgnoreCase(keyword);
    }
    @Override
    public Product createProduct(ProductModel productModel) {
        String productName = productModel.getProductName();
        String technicalName = productModel.getTechnicalName();

        // Check if product type is null
        if (productModel.getProductType() == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }

        Product existingProduct = productRepository.findByProductNameAndTechnicalName(productName, technicalName);
        if (existingProduct != null) {
            // Product with the given name and technical name already exists, update it
            BeanUtils.copyProperties(productModel, existingProduct);
            productRepository.save(existingProduct);
            return existingProduct; // Return the updated product
        }

        // Create a new product based on the product type
        Product product;
        ProductType productType = productModel.getProductType();

        switch (productType) {
            case SEED:
                SeedProduct seedProduct = new SeedProduct();
                seedProduct.setSeedSubType(SeedSubType.valueOf(productModel.getSubType()));  // Convert string to enum
                product = seedProduct;
                break;
            case CROP_PROTECTION:
                CropProtectionProduct cropProtectionProduct = new CropProtectionProduct();
                cropProtectionProduct.setCropProtectionSubType(CropProtectionSubType.valueOf(productModel.getSubType()));  // Convert string to enum
                product = cropProtectionProduct;
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + productType);
        }

        // Set common fields
        Brand brand = brandRepository.findById(productModel.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + productModel.getBrandId()));

        product.setProductName(productName);
        product.setTechnicalName(technicalName);
        product.setDescription(productModel.getDescription());
        product.setBrand(brand);
        product.setMrp(productModel.getMrp());
        product.setEnable(productModel.isEnable());

        // Handle image upload
        try {
            product.setImage(productModel.getImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image: " + e.getMessage());
        }

        // Save the new product
        Product savedProduct = productRepository.save(product);
        return savedProduct; // Return the newly saved product
    }



    ///

    public ProductModel getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return convertToModel(product);
    }

    private ProductModel convertToModel(Product product) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setBrandId(product.getBrand().getId());
        productModel.setProductName(product.getProductName());
        productModel.setTechnicalName(product.getTechnicalName());
        productModel.setDescription(product.getDescription());
        productModel.setMrp(product.getMrp());
        productModel.setEnable(product.isEnable());

        // Determine the product type based on the class of the product instance
        if (product instanceof SeedProduct) {
            productModel.setProductType(ProductType.SEED);
        } else if (product instanceof CropProtectionProduct) {
            productModel.setProductType(ProductType.CROP_PROTECTION);
        }

        // Convert the image byte array to a MultipartFile (if needed, you might need a custom implementation)
        // Assuming you have some utility method to do this conversion
        MultipartFile multipartFile = convertToMultipartFile(product.getImage());
        productModel.setImage(multipartFile);

        return productModel;
    }

    private MultipartFile convertToMultipartFile(byte[] image) {
        // Implementation of converting byte array to MultipartFile (if needed)
        // For now, returning null
        return null;
    }
}

