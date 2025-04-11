package com.colvir.lesson02.components;

import com.colvir.lesson02.services.CelsiusTemperatureConverter;
import org.springframework.stereotype.Component;

@Component("CelsiusToKelvin")
public class CelsiusToKelvinTemperatureConverter implements CelsiusTemperatureConverter {
    @Override
    public float convert(float sourceTemperature) {
        return sourceTemperature + 273.15f;
    }

    @Override
    public String getDestTemperatureTicket() {
        return "K";
    }
}
