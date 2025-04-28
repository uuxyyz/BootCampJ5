package com.colvir.videogamepublisherserver.components;

import com.colvir.videogamepublisherserver.model.VideoGame;
import com.colvir.videogamepublisherserver.model.VideoGameGenre;
import com.colvir.videogamepublisherserver.services.VideoGamePublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class VideoGamePublisherImpl implements VideoGamePublisher {
    public static final String INIT_VERSION = "1.0";
    private final List<VideoGame> videoGames;

    public VideoGamePublisherImpl() {
        this.videoGames = new CopyOnWriteArrayList();
    }

    @Override
    public List<VideoGame> releasedGames() {
        return videoGames;
    }

    @Override
    public List<VideoGame> searchGames(String title, VideoGameGenre genre) {
        return videoGames.stream().filter(
                g -> (Objects.isNull(title) || g.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                        (Objects.isNull(genre) || g.getGenre().equals(genre))).collect(Collectors.toList());
    }

    @Override
    public void releaseNewGame(VideoGame game) {
        game.setVersion(INIT_VERSION);
        videoGames.add(game);
    }

    @Override
    public void patchGame(VideoGame game) {
        videoGames.stream().filter(g -> g.getTitle().equals(game.getTitle())).findFirst().ifPresent(
                g -> {
                    String[] ver = g.getVersion().split(Pattern.quote("."));
                    ver[1] = ver[1] + 1;
                    g.setVersion(ver[0] + "." + ver[1]);
                });
    }
}
