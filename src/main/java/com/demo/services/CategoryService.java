package com.demo.services;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Category;
import io.leangen.graphql.annotations.GraphQLEnumValue;

import java.util.List;

public interface CategoryService {

    enum STATUS {
        @GraphQLEnumValue(description = "Only categories active") ACTIVE,
        @GraphQLEnumValue(description = "Only categories inactive") INACTIVE
    }

    /**
     * Retrieves all categories.
     *
     * @return list of all categories.
     */
    List<Category> findAll();

    /**
     * Find all categories by status.
     *
     * @return list of categories with the specific status.
     */
    List<Category> findByStatue(STATUS status);

    /**
     * Retrieves a Category by its id.
     *
     * @param id value to search.
     * @return the Category with the given id.
     * @throws DemoDontFoundException if Category not found.
     */
    Category findById(Long id) throws DemoDontFoundException;

    /**
     * Retrieves a Category by its name.
     *
     * @param name value to search.
     * @return the Category with the given name.
     * @throws DemoDontFoundException if Category not found.
     */
    Category findByName(String name) throws DemoDontFoundException;

    /**
     * Create a new Category.
     *
     * @param category category's data.
     * @return the Category created.
     */
    Category create(Category category);

    /**
     * Remove a Category.
     *
     * @param id category's id.
     * @return the Category removed.
     */
    Category delete(Long id) throws DemoDontFoundException;
}