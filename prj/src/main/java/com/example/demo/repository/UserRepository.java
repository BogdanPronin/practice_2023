package com.example.demo.repository;

import com.example.demo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO users (user_id, first_name, last_name, email, password, user_role) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getUserRole()
        );
    }
      public List<User> getAllUsers() {
            String selectAllUsersSql = "SELECT * FROM users";
            return jdbcTemplate.query(selectAllUsersSql, BeanPropertyRowMapper.newInstance(User.class));
        }
}

