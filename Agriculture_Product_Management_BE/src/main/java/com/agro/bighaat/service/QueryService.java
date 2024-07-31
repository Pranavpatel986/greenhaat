package com.agro.bighaat.service;

import com.agro.bighaat.entity.Query;

import java.util.List;

public interface QueryService {
    Query save(Query query);

    List<Query> findAll();
}
