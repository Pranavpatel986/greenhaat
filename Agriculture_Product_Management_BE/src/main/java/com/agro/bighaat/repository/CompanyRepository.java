package com.agro.bighaat.repository;

import com.agro.bighaat.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyById(Long companyId);

    Company findByCompanyName(String companyName);
}
