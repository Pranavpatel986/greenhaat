package com.agro.bighaat.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class RetailerProducts {
    @OneToOne
    private Product product;
    private String quantity;
    private boolean available;
}
