package com.flockit.ejercicio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.flockit.ejercicio.models.responses.ProvinciaResponse;
import com.flockit.ejercicio.utils.APIUtils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProvinciaServiceImplTest {

    private final String JSON = "{\"provincias\": [{\"nombre\": \"Santiago del Estero\",\"id\": \"86\",\"centroide\": {\"lat\": -27.782412,\"lon\": -63.252387}}],\"cantidad\": 1,\"total\": 1,\"inicio\": 0}";
    private final String PROVINCIA = "Santiago del Estero";

    @InjectMocks
    ProvinciaServiceImpl provinciaServiceImpl;

    @Mock
    APIUtils apiUtils;

    @Test
    void processRequestSuccess() {
        when(apiUtils.getProvinciaJsonData(PROVINCIA)).thenReturn(JSON);

        ProvinciaResponse provinciaResponse = provinciaServiceImpl.processRequest(PROVINCIA);
        
        assertEquals("-27.782412", provinciaResponse.latitude);
        assertEquals("-63.252387", provinciaResponse.longitude);
    }
}
