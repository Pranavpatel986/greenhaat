package com.agro.bighaat.model;

import com.agro.bighaat.entity.Company;
import com.agro.bighaat.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class BrandModel {
    private Long id;
    private String brandName;
    private Long companyId;
}
