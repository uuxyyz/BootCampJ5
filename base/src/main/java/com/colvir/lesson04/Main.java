package com.colvir.lesson04;

import com.colvir.lesson02.components.TemperatureConverterFactory;
import com.colvir.lesson02.components.TemperatureConverterServiceImpl;
import com.colvir.lesson02.services.TemperatureConverterService;
import com.colvir.lesson04.components.ArchiveFilePathSystemInGetter;
import com.colvir.lesson04.components.ZipArchiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args)) {
            TemperatureConverterService temperatureConverterService =
                    applicationContext.getBean(TemperatureConverterServiceImpl.class);

            temperatureConverterService.convert(
                    TemperatureConverterFactory.TEMP_CONV_CELSIUS_TO_FAHRENHEIT, 104);
            temperatureConverterService.convert(
                    TemperatureConverterFactory.TEMP_CONV_CELSIUS_TO_KELVIN, 104);

            applicationContext.getBean(ZipArchiver.class).archive(
                    applicationContext.getBean(ArchiveFilePathSystemInGetter.class).getFilePath());
        }

    }
}
