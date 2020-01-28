package com.demo.repositories;

import com.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByStatusOrderByName(Integer status);

    Optional<Category> findByName(String name);
}