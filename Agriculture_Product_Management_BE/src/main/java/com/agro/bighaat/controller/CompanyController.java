package com.agro.bighaat.controller;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.entity.Company;
import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.BrandModel;
import com.agro.bighaat.model.CompanyModel;
import com.agro.bighaat.model.ProductModel;
import com.agro.bighaat.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public ResponseEntity<Page<Company>> getAllCompanies(Pageable pageable) {
        Page<Company> companies = companyService.getAllCompanies(pageable);
        return ResponseEntity.ok(companies);
    }
    @PostMapping(value= "/companies")
    public Company saveCompany(@RequestBody CompanyModel companyModel){
        return companyService.createCompany(companyModel);
    }

}
