package com.agro.bighaat.repository;

import com.agro.bighaat.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductNameAndTechnicalName(String productName, String technicalName);
    List<Product> findByProductNameContainingIgnoreCase(String name);
}
