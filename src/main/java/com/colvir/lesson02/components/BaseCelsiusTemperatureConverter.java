package com.colvir.lesson02.components;

import com.colvir.lesson02.services.TemperatureConverter;

public abstract class BaseCelsiusTemperatureConverter implements TemperatureConverter {
    @Override
    public String getSourceTemperatureTicket() {
        return "\u00B0C";
    }
}
