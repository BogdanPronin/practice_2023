package com.example.demo.repository;

import com.example.demo.domain.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCategory(Category category) {
        String sql = "INSERT INTO categories (category_id, category_name, category_description) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                category.getCategoryId(),
                category.getCategoryName(),
                category.getCategoryDescription()
        );
    }


    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
    }
}

