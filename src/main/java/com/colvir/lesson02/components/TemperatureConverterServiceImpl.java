package com.colvir.lesson02.components;

import com.colvir.lesson02.services.TemperatureConverter;
import com.colvir.lesson02.services.TemperatureConverterService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TemperatureConverterServiceImpl implements TemperatureConverterService, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void convert(String type, float sourceTemperature) {
        TemperatureConverter temperatureConverter = applicationContext.getBean(type, TemperatureConverter.class);
        System.out.printf("Результат перевода %s температуры %.2f%s = %.2f%s %n", type, sourceTemperature,
                temperatureConverter.getSourceTemperatureTicket(),
                temperatureConverter.convert(sourceTemperature), temperatureConverter.getDestTemperatureTicket());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
