package com.colvir.lesson07.dao;

import com.colvir.lesson07.model.SparePart;

import java.util.List;

public interface SparePartDao {
    SparePart findById(int id);
    List<SparePart> findAll();
    int delete(int id);
    SparePart save(SparePart sparePart);
}
