package com.demo.controllers;

import com.demo.models.Category;
import com.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = "/categories")
public class CategoryCtrl {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity find(@RequestParam(required = false) Integer status, @RequestParam(required = false) String name) {
        if (status != null) {
            switch (status) {
                case 0:
                    return new ResponseEntity<>(categoryService.findByStatue(CategoryService.STATUS.INACTIVE), HttpStatus.OK);
                case 1:
                    return new ResponseEntity<>(categoryService.findByStatue(CategoryService.STATUS.ACTIVE), HttpStatus.OK);
                default:
                    return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
            }
        }

        if (name != null) {
            return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
        }

        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/games")
    public ResponseEntity getGames(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findById(id).getGames(), HttpStatus.OK);
    }
}