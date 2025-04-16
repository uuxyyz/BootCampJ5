package com.colvir.lesson03;

import com.colvir.lesson03.config.TrucksCarFactoryConfig;
import com.colvir.lesson03.model.Car;
import com.colvir.lesson03.model.CreatedCars;
import com.colvir.lesson03.services.CarFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TrucksCarFactoryConfig.class)) {
            if (createCars(context.getBean(CarFactory.class)) != createCars(context.getBean(CarFactory.class))) {
                System.out.println("works fine");
            }
        }
    }

    private static int createCars(CarFactory carFactory) {
        CreatedCars createdCars = carFactory.createCars();
        for (Car car : createdCars.carList()) {
            System.out.println(car);
        }

        System.out.printf("%d cars created on %d%n", createdCars.carList().size(), createdCars.conveyorId());

        return createdCars.conveyorId();
    }

}
