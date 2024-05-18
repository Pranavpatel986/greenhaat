package com.agro.bighaat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Distributor {
    @Id
    @SequenceGenerator(
            name = "distributor_sequence",
            sequenceName = "distributor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "distributor_sequence"
    )
    private Long id;
    @Column(
            length = 10
    )
    private String contactNo;
    private String firmName;
    @Embedded
    private Location location;

    @ElementCollection
    @CollectionTable(
            name = "distributor_license",
            joinColumns = @JoinColumn(name = "distributor_id")
    )
    private List<License> licenses;
    private String gstNo;
    private String panNo;
//
//    @OneToMany(mappedBy = "distributor", cascade = CascadeType.ALL)
//    private List<DistributorProductStock> productStocks;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountDetail accountDetail;

}
