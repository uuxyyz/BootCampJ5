package com.colvir.lesson07.mapper;

import com.colvir.lesson07.dto.CarTypeDto;
import com.colvir.lesson07.model.CarType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarTypeMapper {

    CarTypeDto toDto(CarType carType);

    CarType toEntity(CarTypeDto carTypeDto);

    default List<CarTypeDto> toDtos(List<CarType> carTypes) {
        return carTypes.stream().map(this::toDto).toList();
    }

}
