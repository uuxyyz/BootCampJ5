package com.colvir.lesson07.services;

import com.colvir.lesson07.dao.CarTypeDao;
import com.colvir.lesson07.dto.CarTypeDto;
import com.colvir.lesson07.mapper.CarTypeMapper;
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
        return carTypeMapper.toDtos(carTypeDao.getCarTypes());
    }
}
