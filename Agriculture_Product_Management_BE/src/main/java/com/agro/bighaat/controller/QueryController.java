package com.agro.bighaat.controller;

import com.agro.bighaat.entity.Query;
import com.agro.bighaat.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queries")
@CrossOrigin(origins = "http://localhost:3000")
public class QueryController {
    @Autowired
    private QueryRepository queryRepository;

    @PostMapping
    public Query createQuery(@RequestBody Query query) {
        return queryRepository.save(query);
    }

    @GetMapping
    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }
}
