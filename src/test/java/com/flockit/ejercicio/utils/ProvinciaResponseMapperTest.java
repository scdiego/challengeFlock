package com.flockit.ejercicio.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.flockit.ejercicio.models.responses.ProvinciaResponse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProvinciaResponseMapperTest {

    private final String JSON = "{\"provincias\": [{\"nombre\": \"Santiago del Estero\",\"id\": \"86\",\"centroide\": {\"lat\": -27.782412,\"lon\": -63.252387}}],\"cantidad\": 1,\"total\": 1,\"inicio\": 0}";
    
    @Test
    void convertSuccess() {
        ProvinciaResponse provinciaResponse = ProvinciaResponseMapper.convert(JSON);
        assertEquals("-27.782412", provinciaResponse.latitude);
        assertEquals("-63.252387", provinciaResponse.longitude);
    }

    @Test
    void convertFailed() {
        ProvinciaResponse provinciaResponse = ProvinciaResponseMapper.convert(JSON);
        assertNotEquals("0", provinciaResponse.latitude);
        assertNotEquals("0", provinciaResponse.longitude);
    }
}
