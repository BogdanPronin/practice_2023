package com.example.demo.repository;

import com.example.demo.domain.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReviewRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addReview(Review review) {
        String sql = "INSERT INTO revi" +
                "ews (review_id, user_id, product_id, rating, review_text, review_date) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                review.getReviewId(),
                review.getUserId(),
                review.getProductId(),
                review.getRating(),
                review.getReviewText(),
                review.getReviewDate()
        );
    }

    public List<Review> getAllReviews() {
        String sql = "SELECT * FROM reviews";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Review.class));
    }
}

