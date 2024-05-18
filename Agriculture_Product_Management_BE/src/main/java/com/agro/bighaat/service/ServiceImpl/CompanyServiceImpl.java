package com.agro.bighaat.service.ServiceImpl;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.entity.Company;
import com.agro.bighaat.entity.Product;
import com.agro.bighaat.model.CompanyModel;
import com.agro.bighaat.repository.CompanyRepository;
import com.agro.bighaat.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> getAllCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
    @Override
    public Company createCompany(CompanyModel companyModel) {
        String companyName = companyModel.getCompanyName();

        Company existingCompany = companyRepository.findByCompanyName(companyName);
        if (existingCompany != null) {
            BeanUtils.copyProperties(companyModel, existingCompany);
            companyRepository.save(existingCompany);
            return existingCompany;
        }

        Company company=new Company();
        company.setCompanyName(companyModel.getCompanyName());
        company.setContactNo(companyModel.getContactNo());

        Company savedCompany = companyRepository.save(company);
        return savedCompany;
    }


}
