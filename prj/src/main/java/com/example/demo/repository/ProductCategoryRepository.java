package com.example.demo.repository;

import com.example.demo.domain.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductCategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProductCategory(ProductCategory productCategory) {
        String sql = "INSERT INTO product_categories (product_id, category_id) VALUES (?, ?)";
        jdbcTemplate.update(
                sql,
                productCategory.getProductId(),
                productCategory.getCategoryId()
        );
    }

    public List<ProductCategory> getAllProductCategories() {
        String sql = "SELECT * FROM product_categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductCategory.class));
    }
}

