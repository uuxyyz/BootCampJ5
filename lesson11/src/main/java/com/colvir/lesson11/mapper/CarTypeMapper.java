package com.colvir.lesson11.mapper;

import com.colvir.lesson11.dto.CarTypeDto;
import com.colvir.lesson11.model.CarType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarTypeMapper {

    CarTypeDto toDto(CarType carType);

    default List<CarTypeDto> toDtos(List<CarType> carTypes) {
        return carTypes.stream().map(this::toDto).toList();
    }

}
