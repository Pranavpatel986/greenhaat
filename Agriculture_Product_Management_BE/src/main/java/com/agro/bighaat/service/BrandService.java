package com.agro.bighaat.service;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.model.BrandModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {


    Page<Brand> getAllBrands(Pageable pageable);

    Brand createBrand(BrandModel brandModel);
}
