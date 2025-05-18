package com.colvir.lesson11.dao;

import com.colvir.lesson11.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartDao extends JpaRepository<SparePart, Integer> {

}
