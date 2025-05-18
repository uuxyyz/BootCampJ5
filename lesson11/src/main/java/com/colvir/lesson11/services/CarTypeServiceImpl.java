package com.colvir.lesson11.services;

import com.colvir.lesson11.dao.CarTypeDao;
import com.colvir.lesson11.dto.CarTypeDto;
import com.colvir.lesson11.mapper.CarTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarTypeServiceImpl implements CarTypeService {
    private final CarTypeDao carTypeDao;
    private final CarTypeMapper carTypeMapper;

    @Override
    public List<CarTypeDto> getCarTypes() {
        return carTypeMapper.toDtos(carTypeDao.findAll().stream().toList());
    }
}
