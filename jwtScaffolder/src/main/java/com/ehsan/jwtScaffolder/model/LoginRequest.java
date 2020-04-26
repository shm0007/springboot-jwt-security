package com.ehsan.jwtScaffolder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {
    @NotNull
    private String name;
    @NotNull
    private String password;
}
