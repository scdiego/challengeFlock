package com.flockit.ejercicio.services;

import com.flockit.ejercicio.models.responses.ProvinciaResponse;
import com.flockit.ejercicio.utils.APIUtils;
import com.flockit.ejercicio.utils.ProvinciaResponseMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    Logger logger = Logger.getLogger(ProvinciaServiceImpl.class);

    @Autowired
    APIUtils apiUtils;

    @Override
    public ProvinciaResponse processRequest(String provincia) {
        logger.info("Empieza busqueda " + provincia + " en la API");
        String json = apiUtils.getProvinciaJsonData(provincia);
        logger.info("Termina busqueda: " + json);
        return ProvinciaResponseMapper.convert(json);
    }
}
