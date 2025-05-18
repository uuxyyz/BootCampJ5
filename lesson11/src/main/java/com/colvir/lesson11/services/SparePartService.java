package com.colvir.lesson11.services;

import com.colvir.lesson11.dto.SparePartDto;

import java.util.List;

public interface SparePartService {
    SparePartDto findById(int id);
    List<SparePartDto> findAll();
    SparePartDto save(SparePartDto sparePartDto);
    void delete(int id);
}
