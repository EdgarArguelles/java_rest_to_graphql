package com.demo.services.implementations;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Category;
import com.demo.repositories.CategoryRepository;
import com.demo.services.CategoryService;
import io.leangen.graphql.annotations.*;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @GraphQLQuery(name = "categories", description = "Find all categories")
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @GraphQLQuery(name = "categoriesByStatue", description = "Find all categories by Status and sorted by Name")
    public List<Category> findByStatue(@GraphQLNonNull @GraphQLArgument(name = "status", description = "Category's status") STATUS status) {
        return categoryRepository.findByStatusOrderByName(status == STATUS.ACTIVE ? 1 : 0);
    }

    @Override
    @GraphQLQuery(name = "category", description = "Find a category by ID")
    public Category findById(@GraphQLId @GraphQLNonNull @GraphQLArgument(name = "id", description = "Category's ID") Long id) throws DemoDontFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new DemoDontFoundException("Nothing with the ID '" + id + "'."));
    }

    @Override
    @GraphQLQuery(name = "categoriesByName", description = "Find a category by Name")
    public Category findByName(@GraphQLNonNull @GraphQLArgument(name = "name", description = "Category's Name") String name) throws DemoDontFoundException {
        return categoryRepository.findByName(name).orElseThrow(() -> new DemoDontFoundException("Nothing with the name '" + name + "'."));
    }

    @Override
    @GraphQLMutation(name = "createCategory", description = "Create a new category")
    public Category create(@GraphQLNonNull @GraphQLArgument(name = "category", description = "New category") Category category) {
        category.setStatus(1);
        return categoryRepository.save(category);
    }

    @Override
    @GraphQLMutation(name = "deleteCategory", description = "Remove a category")
    public Category delete(@GraphQLId @GraphQLNonNull @GraphQLArgument(name = "id", description = "Category's ID") Long id) throws DemoDontFoundException {
        Category category = findById(id);
        categoryRepository.delete(category);
        return category;
    }
}