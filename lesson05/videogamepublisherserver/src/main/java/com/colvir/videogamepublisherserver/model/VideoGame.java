package com.colvir.videogamepublisherserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoGame {
    private String title;
    private VideoGameGenre genre;
    private int pegiInfo;
    private int playersCount;
    private String version;
}
