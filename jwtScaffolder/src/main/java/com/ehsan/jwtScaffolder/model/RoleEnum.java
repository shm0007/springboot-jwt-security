package com.ehsan.jwtScaffolder.model;

public enum RoleEnum {
    ADMIN("ADMIN"),
    REGULER("REGULER");
    private String value;
    RoleEnum(String role){
        value= role;
    }
    public String getValue(){
        return value;
    }
}
