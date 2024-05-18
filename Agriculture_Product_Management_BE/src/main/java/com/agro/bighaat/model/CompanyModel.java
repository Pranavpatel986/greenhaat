package com.agro.bighaat.model;

import lombok.Data;

import java.util.List;

@Data
public class CompanyModel {

    private Long id;
    private String companyName;
    private String contactNo;
    private List<BrandModel> brands;
}
