package com.colvir.lesson07.services;

import com.colvir.lesson07.dto.SparePartDto;

import java.util.List;

public interface SparePartService {
    SparePartDto findById(int id);
    List<SparePartDto> findAll();
    SparePartDto save(SparePartDto sparePartDto);
    int delete(int id);
}
