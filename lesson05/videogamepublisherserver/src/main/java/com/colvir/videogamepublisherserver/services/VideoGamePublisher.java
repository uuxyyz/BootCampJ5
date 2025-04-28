package com.colvir.videogamepublisherserver.services;

import com.colvir.videogamepublisherserver.model.VideoGame;
import com.colvir.videogamepublisherserver.model.VideoGameGenre;

import java.util.List;

public interface VideoGamePublisher {
    List<VideoGame> releasedGames();
    List<VideoGame> searchGames(String title, VideoGameGenre genre);
    void releaseNewGame(VideoGame game);
    void patchGame(VideoGame game);

}
