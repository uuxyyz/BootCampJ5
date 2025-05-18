package com.colvir.lesson11.mapper;

import com.colvir.lesson11.dto.SparePartDto;
import com.colvir.lesson11.model.SparePart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SparePartMapper {

    SparePartDto toDto(SparePart sparePart);

    SparePart toEntity(SparePartDto sparePartDto);

    default List<SparePartDto> toDtos(List<SparePart> spareParts) {
        return spareParts.stream().map(this::toDto).toList();
    }

}
