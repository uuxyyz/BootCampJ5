package com.colvir.videogamepublisherserver.mapper;

import com.colvir.videogamepublisherserver.dto.VideoGameDto;
import com.colvir.videogamepublisherserver.model.VideoGame;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface VideoGameMapper {

    VideoGameDto toDto(VideoGame account);

    VideoGame toEntity(VideoGameDto account);

    default List<VideoGameDto> toDtos(List<VideoGame> videoGameList) {
        return videoGameList.stream().map(this::toDto).toList();
    }

}
