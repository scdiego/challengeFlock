package com.flockit.ejercicio.controllers;

import com.flockit.ejercicio.exceptions.UserLoginException;
import com.flockit.ejercicio.models.requests.LoginRequest;
import com.flockit.ejercicio.models.responses.LoginResponse;
import com.flockit.ejercicio.services.LoginServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class LoginController {

    Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/api/auth/login")
    @Operation(responses = {
        @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = LoginResponse.class)), description = "Login successful"),
        @ApiResponse(responseCode = "400", description = "Not valid username or password")})
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest authenticationRequest) {
        try {
            return ResponseEntity.ok(loginService.processRequest(authenticationRequest.username, authenticationRequest.password));
        } catch (UserLoginException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
