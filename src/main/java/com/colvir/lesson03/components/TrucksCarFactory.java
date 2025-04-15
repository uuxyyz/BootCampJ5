package com.colvir.lesson03.components;

import com.colvir.lesson03.model.Car;
import com.colvir.lesson03.services.CarConveyor;
import com.colvir.lesson03.services.CarFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrucksCarFactory implements CarFactory {
    private final CarConveyor carConveyor;

    public TrucksCarFactory(CarConveyor carConveyor) {
        this.carConveyor = carConveyor;
    }

    @Override
    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(carConveyor.createCar());
        }

        return cars;
    }

    @Override
    public CarConveyor getCarConveyor() {
        return carConveyor;
    }
}
