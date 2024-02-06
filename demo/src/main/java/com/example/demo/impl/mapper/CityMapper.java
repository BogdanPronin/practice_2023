package com.example.demo.impl.mapper;

import com.example.demo.api.dto.CityDTO;
import com.example.demo.domain.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(target = "id", ignore = true)
    City cityDtoToCity(CityDTO cityDTO);

    CityDTO cityToCityDto(City city);
}

