package com.colvir.lesson07.services;

import com.colvir.lesson07.dao.SparePartDao;
import com.colvir.lesson07.dto.SparePartDto;
import com.colvir.lesson07.mapper.SparePartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SparePartServiceImpl implements SparePartService {

    private final SparePartDao sparePartDao;
    private final SparePartMapper sparePartMapper;

    public SparePartDto findById(int id) {
        return sparePartMapper.toDto(sparePartDao.findById(id));
    }

    public List<SparePartDto> findAll() {
        return sparePartMapper.toDtos(sparePartDao.findAll());
    }

    public SparePartDto save(SparePartDto sparePartDto) {
        return sparePartMapper.toDto(sparePartDao.save(sparePartMapper.toEntity(sparePartDto)));
    }

    public int delete(int id) {
        return sparePartDao.delete(id);
    }


}
