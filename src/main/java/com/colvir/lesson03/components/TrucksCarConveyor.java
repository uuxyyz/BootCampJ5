package com.colvir.lesson03.components;

import com.colvir.lesson03.model.Car;
import com.colvir.lesson03.services.CarConveyor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TrucksCarConveyor implements CarConveyor {
    public static final AtomicInteger id = new AtomicInteger();
    public static final AtomicInteger createCount = new AtomicInteger();

    public TrucksCarConveyor() {
        id.incrementAndGet();
    }

    @Override
    public Car createCar() {
        return new Car() {
            @Override
            public String getVin() {
                return String.format("X-%s-D-%d-ID-%d-%d",
                        UUID.randomUUID().toString().substring(0, 6).replace("-", "").toUpperCase(),
                        new Date().getTime(), getId(), createCount.incrementAndGet());
            }

            @Override
            public String getModelName() {
                return "MadMax";
            }

            @Override
            public String toString() {
                return "Car{Truck:" + getModelName() + ",vin=" + getVin() + '}';
            }
        };
    }

    @Override
    public int getId() {
        return id.get();
    }

}
