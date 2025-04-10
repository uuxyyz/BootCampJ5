package com.colvir.lesson02.components;

import com.colvir.lesson02.services.TemperatureConverter;
import com.colvir.lesson02.services.TemperatureConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TemperatureConverterServiceImpl implements TemperatureConverterService {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void convert(String type, float sourceTemperature) {

        TemperatureConverter temperatureConverter = applicationContext.getBean(type, TemperatureConverter.class);
        System.out.printf("Результат перевода %s температуры %.2f%s = %.2f%s %n", type, sourceTemperature,
                temperatureConverter.getSourceTemperatureTicket(),
                temperatureConverter.convert(sourceTemperature), temperatureConverter.getDestTemperatureTicket());
    }
}
