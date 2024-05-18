package com.agro.bighaat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Retailer {
    @Id
    @SequenceGenerator(
            name = "retailer_sequence",
            sequenceName = "retailer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "retailer_sequence"
    )
    private Long id;
    private String firmName;
    @Column(
            length = 10
    )
    private String contactNo;
    //    private List<Product> productList;
    @Embedded
    private Location location;

    @ElementCollection
    @CollectionTable(
            name = "retailer_license",
            joinColumns = @JoinColumn(name = "retailer_id")
    )
    private List<License> licenses;
    private String gstNo;
    private String panNo;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountDetail accountDetail;

}