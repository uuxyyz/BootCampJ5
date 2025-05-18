package com.colvir.lesson11.dao;

import com.colvir.lesson11.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeDao extends JpaRepository<CarType, Integer> {

}
