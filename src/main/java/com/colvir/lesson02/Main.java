package com.colvir.lesson02;

import com.colvir.lesson02.components.TemperatureConverterServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.colvir.lesson02");
        applicationContext.getBean(TemperatureConverterServiceImpl.class)
                .convert("CelsiusToFahrenheit", 10);
        applicationContext.getBean(TemperatureConverterServiceImpl.class)
                .convert("CelsiusToKelvin", 10);

    }
}
