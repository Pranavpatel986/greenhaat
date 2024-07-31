package com.agro.bighaat.controller;

import com.agro.bighaat.entity.Query;
import com.agro.bighaat.repository.QueryRepository;
import com.agro.bighaat.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queries")
@CrossOrigin(origins = "http://localhost:3000")
public class QueryController {
    @Autowired
    private QueryService queryService;

    @PostMapping
    public Query createQuery(@RequestBody Query query) {
        return queryService.save(query);
    }


}
