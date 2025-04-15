package com.colvir.lesson03;

import com.colvir.lesson03.config.TrucksCarFactoryConfig;
import com.colvir.lesson03.model.Car;
import com.colvir.lesson03.services.CarFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TrucksCarFactoryConfig.class)) {
            createCars(context.getBean(CarFactory.class));
            createCars(context.getBean(CarFactory.class));
        }
    }

    private static void createCars(CarFactory carFactory) {
        for (Car car : carFactory.createCars()) {
            System.out.println(car);
        }

        System.out.println(carFactory.getCarConveyor().createCar());
        System.out.println("cars created");
    }

}
