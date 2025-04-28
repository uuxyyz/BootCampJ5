package com.colvir.videogamepublisherclient.services;

import java.io.IOException;

public interface VideoGamePublisherClient {
    void addGames() throws IOException;
    void printGames() throws IOException;
}
