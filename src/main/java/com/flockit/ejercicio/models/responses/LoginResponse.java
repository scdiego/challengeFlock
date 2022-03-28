package com.flockit.ejercicio.models.responses;

public class LoginResponse {
    public String username;
    public final String MESSAGE = "Login exitoso";

    public LoginResponse(String username) {
        this.username = username;
    }
}
