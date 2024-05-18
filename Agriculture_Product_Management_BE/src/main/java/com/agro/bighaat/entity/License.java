package com.agro.bighaat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
public class License {

    @Enumerated(EnumType.STRING)
    private LicenseType licenseType;
    private String licenseNo;
}
