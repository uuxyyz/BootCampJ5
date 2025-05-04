package com.colvir.lesson07.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SparePart {
    private Integer id;
    private CarType carType;
    private String name;
    private float cost;
}
