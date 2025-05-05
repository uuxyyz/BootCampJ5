package com.colvir.lesson07.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SparePartDto {
    private Integer id;
    @NotNull
    private CarTypeDto carType;
    @NotEmpty
    private String name;
    @NotNull
    private float cost;
}
