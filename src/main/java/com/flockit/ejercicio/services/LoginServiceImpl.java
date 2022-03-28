package com.flockit.ejercicio.services;

import com.flockit.ejercicio.entities.User;
import com.flockit.ejercicio.exceptions.UserLoginException;
import com.flockit.ejercicio.models.responses.LoginResponse;
import com.flockit.ejercicio.repositories.LoginRepo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    LoginRepo loginRepo;

    @Override
    public LoginResponse processRequest(String username, String password) throws UserLoginException {
        logger.info("Buscando usuario: " + username);
        User user = loginRepo.findByUsername(username);
        if(user == null || !user.getPassword().equals(password)) {
            throw new UserLoginException("User o Password invalido");
        }
        logger.info("Usuario encontrado");
        return new LoginResponse(user.getUsername());
    }
    
}
