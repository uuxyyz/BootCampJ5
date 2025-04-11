package com.colvir.lesson02.services;

import org.springframework.stereotype.Component;

@Component
public interface TemperatureConverterService {
    void convert(String type, float sourceTemperature);
}
