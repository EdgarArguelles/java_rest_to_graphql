package com.demo.services;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Store;

import java.util.List;

public interface StoreService {

    /**
     * Retrieves all stores.
     *
     * @return list of all stores.
     */
    List<Store> findAll();

    /**
     * Retrieves a Store by its id.
     *
     * @param id value to search.
     * @return the Store with the given id.
     * @throws DemoDontFoundException if Store not found.
     */
    Store findById(Long id) throws DemoDontFoundException;
}