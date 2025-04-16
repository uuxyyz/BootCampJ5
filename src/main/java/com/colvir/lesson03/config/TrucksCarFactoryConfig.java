package com.colvir.lesson03.config;

import com.colvir.lesson03.components.TrucksCarConveyor;
import com.colvir.lesson03.components.TrucksCarFactory;
import com.colvir.lesson03.services.CarConveyor;
import com.colvir.lesson03.services.CarFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.colvir.lesson03.components")
public class TrucksCarFactoryConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CarConveyor trucksCarConveyor() {
        return new TrucksCarConveyor();
    }

    @Bean
    public CarFactory trucksCarFactory(ObjectFactory<CarConveyor> carConveyorObjectFactory) {
        return new TrucksCarFactory(carConveyorObjectFactory);
    }

}
