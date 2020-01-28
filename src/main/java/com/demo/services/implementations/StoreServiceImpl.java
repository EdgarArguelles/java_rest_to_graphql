package com.demo.services.implementations;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Store;
import com.demo.repositories.StoreRepository;
import com.demo.services.StoreService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    @GraphQLQuery(name = "stores", description = "Find all stores")
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    @GraphQLQuery(name = "store", description = "Find a store by ID")
    public Store findById(@GraphQLId @GraphQLNonNull @GraphQLArgument(name = "id", description = "Store's ID") Long id) throws DemoDontFoundException {
        return storeRepository.findById(id).orElseThrow(() -> new DemoDontFoundException("Nothing with the ID '" + id + "'."));
    }
}