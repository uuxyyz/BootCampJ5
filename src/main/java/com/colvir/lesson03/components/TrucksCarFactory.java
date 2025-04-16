package com.colvir.lesson03.components;

import com.colvir.lesson03.model.Car;
import com.colvir.lesson03.model.CreatedCars;
import com.colvir.lesson03.services.CarConveyor;
import com.colvir.lesson03.services.CarFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrucksCarFactory implements CarFactory {
    public TrucksCarFactory(ObjectFactory<CarConveyor> carConveyorObjectFactory) {
        this.carConveyorObjectFactory = carConveyorObjectFactory;
    }

    private final ObjectFactory<CarConveyor> carConveyorObjectFactory;

    @Override
    public CreatedCars createCars() {
        CarConveyor carConveyor = getCarConveyor();
        List<Car> carLst = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carLst.add(carConveyor.createCar());
        }

        return new CreatedCars(carLst, carConveyor.getId());
    }

    private CarConveyor getCarConveyor() {
        return carConveyorObjectFactory.getObject();
    }

}
