package com.agro.bighaat.model;

import com.agro.bighaat.entity.ProductType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductModel {
    private Long id;
    private Long brandId;
    private String productName;
    private String technicalName;
    private String description;
    private MultipartFile image;
    private String mrp;
    private ProductType productType;
    private String SubType;
    private boolean enable;
}
