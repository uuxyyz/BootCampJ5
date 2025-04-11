package com.colvir.lesson02.components;

import com.colvir.lesson02.services.TemperatureConverter;
import org.springframework.stereotype.Component;

@Component("CelsiusToKelvin")
public class CelsiusToKelvinTemperatureConverter extends BaseCelsiusTemperatureConverter implements TemperatureConverter {
    @Override
    public float convert(float sourceTemperature) {
        return sourceTemperature + 273.15f;
    }

    @Override
    public String getDestTemperatureTicket() {
        return "K";
    }
}
