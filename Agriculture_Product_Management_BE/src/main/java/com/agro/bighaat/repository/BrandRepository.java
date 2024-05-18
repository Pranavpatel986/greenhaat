package com.agro.bighaat.repository;

import com.agro.bighaat.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByBrandName(String brandName);
    Brand findBrandById(Long brandId);
}
