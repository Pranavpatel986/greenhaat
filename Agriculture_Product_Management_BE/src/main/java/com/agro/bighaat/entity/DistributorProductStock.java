package com.agro.bighaat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class DistributorProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name = "distributor_products",
            joinColumns = @JoinColumn(name = "distributorProductStock_id")
    )
    private List<DistributorProducts> products;

    @OneToOne
    private Distributor distributor;

}
