package com.demo.services.implementations;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Store;
import com.demo.repositories.StoreRepository;
import com.demo.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(Long id) throws DemoDontFoundException {
        return storeRepository.findById(id).orElseThrow(() -> new DemoDontFoundException("Nothing with the ID '" + id + "'."));
    }
}