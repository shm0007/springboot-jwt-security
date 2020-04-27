package com.ehsan.jwtScaffolder.model;

import lombok.Data;

import java.util.List;

@Data

public class SignInResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    public SignInResponse(String token, String username){
        this.token = token;
        this.username = username;
    }
}
