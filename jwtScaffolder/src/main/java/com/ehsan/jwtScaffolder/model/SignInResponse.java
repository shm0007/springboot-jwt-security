package com.ehsan.jwtScaffolder.model;

import lombok.Data;

import java.util.List;

@Data

public class SignInResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private List<String> roles;
    public SignInResponse(String token, String username, List<String> roles){
        this.token = token;
        this.username = username;
        this.roles= roles;
    }
}
