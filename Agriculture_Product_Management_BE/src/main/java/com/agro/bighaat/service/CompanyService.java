package com.agro.bighaat.service;

import com.agro.bighaat.entity.Company;
import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.CompanyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Company createCompany(CompanyModel companyModel);

    Page<Company> getAllCompanies(Pageable pageable);

}
