package com.colvir.lesson02.services;

public interface TemperatureConverter {
    float convert(float sourceTemperature);

    String getSourceTemperatureTicket();

    String getDestTemperatureTicket();
}
