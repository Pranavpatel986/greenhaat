package com.agro.bighaat.controller;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.entity.Company;
import com.agro.bighaat.entity.Product;
import com.agro.bighaat.entity.Query;
import com.agro.bighaat.model.BrandModel;
import com.agro.bighaat.model.CompanyModel;
import com.agro.bighaat.model.ProductModel;
import com.agro.bighaat.service.BrandService;
import com.agro.bighaat.service.CompanyService;
import com.agro.bighaat.service.ProductService;
import com.agro.bighaat.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    ///brand

    @Autowired
    private BrandService brandService;
    @PostMapping(value= "/brands")
    public Brand saveBrand(@RequestBody BrandModel brandModel){
        return brandService.createBrand(brandModel);
    }


    ///Query
    @Autowired
    private QueryService queryService;

    @GetMapping
    public List<Query> getAllQueries() {
        return queryService.findAll();
    }

    ///company
    @Autowired
    private CompanyService companyService;
    @PostMapping(value= "/companies")
    public Company saveCompany(@RequestBody CompanyModel companyModel){
        return companyService.createCompany(companyModel);
    }


    ///product
    @Autowired
    public ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@ModelAttribute ProductModel productModel) {
        Product product = productService.createProduct(productModel);
        return ResponseEntity.ok(product);
    }
}
