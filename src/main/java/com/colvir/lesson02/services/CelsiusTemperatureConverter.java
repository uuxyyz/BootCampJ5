package com.colvir.lesson02.services;

public interface CelsiusTemperatureConverter extends TemperatureConverter {
    @Override
    default String getSourceTemperatureTicket() {
        return "C";
    }
}
