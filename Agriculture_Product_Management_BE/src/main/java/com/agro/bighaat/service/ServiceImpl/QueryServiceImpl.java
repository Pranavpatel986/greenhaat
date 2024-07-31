package com.agro.bighaat.service.ServiceImpl;

import com.agro.bighaat.entity.Customer;
import com.agro.bighaat.entity.Query;
import com.agro.bighaat.repository.CustomerRepository;
import com.agro.bighaat.repository.QueryRepository;
import com.agro.bighaat.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryRepository queryRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Query save(Query query) {
        Customer customer=new Customer();
        customer.setName(query.getCustomerName());
        customer.setEmail(query.getCustomerEmail());
        customer.setContactNo(query.getContactNo());

        customerRepository.save(customer);

        ///mail ka kam baki he

        return queryRepository.save(query);
    }

    @Override
    public List<Query> findAll() {
        return queryRepository.findAll();
    }
}
