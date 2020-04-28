package com.ehsan.jwtScaffolder.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RestaurantResponse {
    @NotNull
    private String name;
    @NotNull
    private String password;
}
