package com.flockit.ejercicio.utils;

import com.fasterxml.classmate.TypeResolver;
import com.flockit.ejercicio.models.responses.LoginResponse;
import com.flockit.ejercicio.models.responses.ProvinciaResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(typeResolver.resolve(LoginResponse.class), typeResolver.resolve(ProvinciaResponse.class))
                .select().apis(RequestHandlerSelectors.basePackage("com")).paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false);
    }

}
