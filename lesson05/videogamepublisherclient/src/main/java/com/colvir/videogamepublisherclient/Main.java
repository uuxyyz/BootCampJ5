package com.colvir.videogamepublisherclient;

import com.colvir.videogamepublisherclient.services.VideoGamePublisherClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args)) {
            VideoGamePublisherClient videoGamePublisherClient = applicationContext.getBean(VideoGamePublisherClient.class);
            videoGamePublisherClient.addGames();
            videoGamePublisherClient.printGames();
        }

    }
}
