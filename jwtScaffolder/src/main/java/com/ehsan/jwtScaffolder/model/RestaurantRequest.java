package com.ehsan.jwtScaffolder.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RestaurantRequest {
    @NotNull
    private String name;

    @NotNull
    private String location;
}
