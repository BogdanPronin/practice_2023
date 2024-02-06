package com.example.demo.domain.repository;

import com.example.demo.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
