package com.retiel_restfulapi.restapi.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String usernamePengguna;
    private String passwordPengguna;
}