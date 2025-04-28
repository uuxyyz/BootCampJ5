package com.colvir.videogamepublisherserver.controller;

import com.colvir.videogamepublisherserver.dto.VideoGameDto;
import com.colvir.videogamepublisherserver.mapper.VideoGameMapper;
import com.colvir.videogamepublisherserver.model.VideoGameGenre;
import com.colvir.videogamepublisherserver.services.VideoGamePublisher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/VideoGamePublisher")
public class VideoGamePublisherController {
    private final VideoGamePublisher videoGamePublisher;
    private final VideoGameMapper videoGameMapper;

    @GetMapping
    public List<VideoGameDto> releasedGames() {
        return videoGameMapper.toDtos(videoGamePublisher.releasedGames());
    }

    @GetMapping("search")
    public List<VideoGameDto> searchGames(@RequestParam(required = false) String title,
                                       @RequestParam(required = false) VideoGameGenre genre) {
        return videoGameMapper.toDtos(videoGamePublisher.searchGames(title, genre));
    }

    @PutMapping("release")
    public void releaseNewGame(@RequestBody @Valid VideoGameDto game) {
        videoGamePublisher.releaseNewGame(videoGameMapper.toEntity(game));
    }

    @PostMapping("patch")
    public void patchGame(VideoGameDto game) {
        videoGamePublisher.patchGame(videoGameMapper.toEntity(game));
    }
}
