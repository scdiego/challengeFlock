package com.flockit.ejercicio.controllers;

import com.flockit.ejercicio.models.responses.ProvinciaResponse;
import com.flockit.ejercicio.services.ProvinciaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class ProvinciaController {

    @Autowired
    ProvinciaServiceImpl provinciaService;

    @GetMapping("/api/ubicacion/{provincia}")
    @Operation(responses =  {
        @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProvinciaResponse.class)), description = "Fetch successful"),
        @ApiResponse(responseCode = "400", description = "Not found results for given parameter")})
    public ResponseEntity<?> ubicacionGeografica(@PathVariable String provincia) {
        ProvinciaResponse provinciaResponse = provinciaService.processRequest(provincia);
        if(provinciaResponse.latitude.isEmpty() || provinciaResponse.longitude.isEmpty()) {
            return new ResponseEntity<>("No hay resultados para " + provincia, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(provinciaResponse);
    }
}
