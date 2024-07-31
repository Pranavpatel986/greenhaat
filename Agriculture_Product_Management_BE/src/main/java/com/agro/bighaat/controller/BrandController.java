package com.agro.bighaat.controller;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.entity.Company;
import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.BrandModel;
import com.agro.bighaat.model.ProductModel;
import com.agro.bighaat.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/brands")
    public ResponseEntity<Page<Brand>> getAllBrands(Pageable pageable) {
        Page<Brand> brands = brandService.getAllBrands(pageable);
        return ResponseEntity.ok(brands);
    }

}


//String companyName = companyModel.getCompanyName();
//Company existingCompany = companyService.findByCompanyName(companyName);
//        if (existingCompany != null) {
//        // Product with the given name and technical name already exists, update it
//        BeanUtils.copyProperties(companyModel, existingCompany);
//            companyService.save(existingCompany);
//            return existingCompany; // Return the updated product
//        }
//
//Company company=new Company();
//
//        company.setCompanyName(companyModel.getCompanyName());
//Company savedCompany = companyService.save(company);
//        return savedCompany; // Return the newly saved product