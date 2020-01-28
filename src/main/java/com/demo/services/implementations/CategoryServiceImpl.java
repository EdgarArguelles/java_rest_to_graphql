package com.demo.services.implementations;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Category;
import com.demo.repositories.CategoryRepository;
import com.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findByStatue(STATUS status) {
        return categoryRepository.findByStatusOrderByName(status == STATUS.ACTIVE ? 1 : 0);
    }

    @Override
    public Category findById(Long id) throws DemoDontFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new DemoDontFoundException("Nothing with the ID '" + id + "'."));
    }

    @Override
    public Category findByName(String name) throws DemoDontFoundException {
        return categoryRepository.findByName(name).orElseThrow(() -> new DemoDontFoundException("Nothing with the name '" + name + "'."));
    }

    @Override
    public Category create(Category category) {
        category.setStatus(1);
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(Long id) throws DemoDontFoundException {
        Category category = findById(id);
        categoryRepository.delete(category);
        return category;
    }
}