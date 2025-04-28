package com.colvir.lesson02.components;

import com.colvir.lesson02.services.CelsiusTemperatureConverter;
import org.springframework.stereotype.Component;

@Component(TemperatureConverterFactory.TEMP_CONV_CELSIUS_TO_FAHRENHEIT)
public class CelsiusToFahrenheitTemperatureConverter implements CelsiusTemperatureConverter {
    @Override
    public float convert(float sourceTemperature) {
        return (sourceTemperature * 9 / 5) + 32;
    }

    @Override
    public String getDestTemperatureTicket() {
        return "°";
    }
}
