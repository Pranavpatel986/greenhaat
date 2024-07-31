package com.agro.bighaat.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("CROP_PROTECTION")
public class CropProtectionProduct extends Product {
    @Enumerated(EnumType.STRING)
    private CropProtectionSubType cropProtectionSubType;
}