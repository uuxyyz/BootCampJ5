package com.colvir.lesson03.model;

import java.util.List;

public class CreatedCars {
    public List<Car> getCarList() {
        return carList;
    }

    public int getConveyorId() {
        return conveyorId;
    }

    private final List<Car> carList;

    private final int conveyorId;

    public CreatedCars(List<Car> carList, int conveyorId) {
        this.carList = carList;
        this.conveyorId = conveyorId;
    }

}
