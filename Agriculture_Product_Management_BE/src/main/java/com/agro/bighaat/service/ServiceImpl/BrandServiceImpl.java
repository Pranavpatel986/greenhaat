package com.agro.bighaat.service.ServiceImpl;

import com.agro.bighaat.entity.Brand;
import com.agro.bighaat.entity.Company;
import com.agro.bighaat.model.BrandModel;
import com.agro.bighaat.repository.BrandRepository;
import com.agro.bighaat.repository.CompanyRepository;
import com.agro.bighaat.service.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CompanyRepository companyRepository;

//    pivate CompanyR
    @Override
    public Page<Brand> getAllBrands(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Brand createBrand(BrandModel brandModel) {
        String brandName = brandModel.getBrandName();

        Brand existingBrand = brandRepository.findByBrandName(brandName);
        if (existingBrand != null) {
            // Product with the given name and technical name already exists, update it
            BeanUtils.copyProperties(brandModel, existingBrand);
            brandRepository.save(existingBrand);
            return existingBrand; // Return the updated product
        }

        Brand brand = new Brand();
        Company company=companyRepository.findCompanyById(brandModel.getCompanyId());
        brand.setBrandName(brandModel.getBrandName());
        brand.setCompany(company);

        Brand savedBrand = brandRepository.save(brand);
        return savedBrand; // Return the newly saved product
    }
}
