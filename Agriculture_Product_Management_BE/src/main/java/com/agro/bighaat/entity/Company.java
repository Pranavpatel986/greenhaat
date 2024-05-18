package com.agro.bighaat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String companyName;

    @Column(
            length = 10
    )
    private String contactNo;
    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Brand> brand;

    @OneToOne
    private CompanyBrandAndProductsStock companyBrandAndProductsStocks;

    @ElementCollection(targetClass = Location.class)
    private List<Location> locations;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountDetail accountDetail;

}
