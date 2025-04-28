package com.colvir.videogamepublisherserver.dto;

import com.colvir.videogamepublisherserver.model.VideoGameGenre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoGameDto {
    @NotEmpty
    private String title;
    @NotNull
    private VideoGameGenre genre;
    private Integer pegiInfo;
    private Integer playersCount;
    private String version;
}
