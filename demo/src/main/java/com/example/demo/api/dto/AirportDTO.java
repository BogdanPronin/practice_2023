package com.example.demo.api.dto;

import java.util.Objects;

public class AirportDTO {

    private Long id;
    private String name;
    private Long cityId;

    public AirportDTO() {
    }

    public AirportDTO(String name, Long cityId) {
        this.name = name;
        this.cityId = cityId;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportDTO that = (AirportDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cityId, that.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityId);
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
