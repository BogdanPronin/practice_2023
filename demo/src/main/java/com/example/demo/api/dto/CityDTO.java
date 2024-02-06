package com.example.demo.api.dto;

import java.util.Objects;

public class CityDTO {
    private Long id;
    private String name;

    public CityDTO() {
    }

    public CityDTO(String name) {
        this.name = name;
    }

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return Objects.equals(id, cityDTO.id) && Objects.equals(name, cityDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
