package com.agro.bighaat.repository;

import com.agro.bighaat.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductNameAndTechnicalName(String productName, String technicalName);
}
