package com.agro.bighaat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    ///mapping product with brand
    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;


    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String technicalName;
    @Column(columnDefinition = "VARCHAR(255)")
    private String description;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @Column(name = "max_retail_price", nullable = false,columnDefinition = "VARCHAR(255)")
    private String mrp;

    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private boolean enable;

}