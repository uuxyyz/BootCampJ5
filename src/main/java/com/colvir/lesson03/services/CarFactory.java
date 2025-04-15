package com.colvir.lesson03.services;

import com.colvir.lesson03.model.Car;

import java.util.List;

public interface CarFactory {
    List<Car> createCars();
    CarConveyor getCarConveyor();
}
