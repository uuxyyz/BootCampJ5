package com.colvir.videogamepublisherclient.components;

import com.colvir.videogamepublisherclient.config.VideoGamePublisherClientConfig;
import com.colvir.videogamepublisherclient.services.VideoGamePublisherClient;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class VideoGamePublisherClientImpl implements VideoGamePublisherClient {

    public static final String API_PATH_RELEASE = "/release";
    private final VideoGamePublisherClientConfig config;

    public VideoGamePublisherClientImpl(VideoGamePublisherClientConfig config) {
        this.config = config;
    }

    private void addGame(String title, String genre, int pegiInfo, int playersCount) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.format("{\"title\":\"%s\",\"genre\":\"%s\",\"pegiInfo\":%d," +
                "\"playersCount\":%d}", title, genre, pegiInfo, playersCount));
        Request request = new Request.Builder()
                .url(getUrl(API_PATH_RELEASE))
                .method("PUT", body)
                .build();
        client.newCall(request).execute();
    }

    private String getUrl(String path) {
        return config.getUrl() + path;
    }

    @Override
    public void addGames() throws IOException {

        // Как бы Electronic arts
        addGame("FIFA 1998", "Sport", 8, 2);
        addGame("Battlefield 2042", "Shooter", 18, 64);
        addGame("Mass Effect", "RPG", 18, 1 );

    }

    @Override
    public void printGames() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getUrl(""))
                .method("GET", null)
                .build();
        try (ResponseBody body = client.newCall(request).execute().body()) {
            System.out.println(body.string());
        }
    }
}
