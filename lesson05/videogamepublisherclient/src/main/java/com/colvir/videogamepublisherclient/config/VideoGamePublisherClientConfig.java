package com.colvir.videogamepublisherclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:videogamepublisherclient.properties")
public class VideoGamePublisherClientConfig {
    public String getUrl() {
        return url;
    }

    @Value("${url}")
    private String url;
}
