package com.flockit.ejercicio.services;

import com.flockit.ejercicio.exceptions.UserLoginException;
import com.flockit.ejercicio.models.responses.LoginResponse;

public interface LoginService {
    
    public LoginResponse processRequest(String username, String password) throws UserLoginException;
    
}
