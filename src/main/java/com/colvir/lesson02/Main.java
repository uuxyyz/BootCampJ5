package com.colvir.lesson02;

import com.colvir.lesson02.components.TemperatureConverterServiceImpl;
import com.colvir.lesson02.services.TemperatureConverterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        TemperatureConverterService temperatureConverterService =
                new AnnotationConfigApplicationContext("com.colvir.lesson02")
                        .getBean(TemperatureConverterServiceImpl.class);

        temperatureConverterService.convert("CelsiusToFahrenheit", 10);
        temperatureConverterService.convert("CelsiusToKelvin", 10);
    }
}
