package com.example.demo.api.controller;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryController(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        List<ProductCategory> productCategories = productCategoryRepository.getAllProductCategories();
        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryRepository.addProductCategory(productCategory);
        return new ResponseEntity<>("Product category added successfully!", HttpStatus.CREATED);
    }
}

