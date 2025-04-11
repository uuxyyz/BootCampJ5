package com.colvir.lesson02.components;

import com.colvir.lesson02.services.TemperatureConverter;
import org.springframework.stereotype.Component;

@Component("CelsiusToFahrenheit")
public class CelsiusToFahrenheitTemperatureConverter extends BaseCelsiusTemperatureConverter implements TemperatureConverter {
    @Override
    public float convert(float sourceTemperature) {
        return (sourceTemperature * 9 / 5) + 32;
    }

    @Override
    public String getDestTemperatureTicket() {
        return "\u00B0F";
    }
}
