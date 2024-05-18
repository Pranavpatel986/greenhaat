package com.agro.bighaat.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Location {
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
