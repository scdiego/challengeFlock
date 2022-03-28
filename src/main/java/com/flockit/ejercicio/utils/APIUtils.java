package com.flockit.ejercicio.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class APIUtils {

    Logger logger = Logger.getLogger(APIUtils.class);

    public String getProvinciaJsonData(String provincia) {
        
        String result = "";

        try {

            URL url = new URL("https://apis.datos.gob.ar/georef/api/provincias?nombre=" + provincia);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            result = content.toString();
            
        } catch(Exception e) {

            logger.error("API response error", e);

        }
        return result;
    }

    
}
