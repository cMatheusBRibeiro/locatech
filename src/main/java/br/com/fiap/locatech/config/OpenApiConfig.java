package br.com.fiap.locatech.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPILocatech () {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Locatech API")
                                .description("Projeto desenvolvido na Postech Fiap de Arquitetura Java")
                                .version("v0.0.1")
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                                .url("https://github.com/cMatheusBRibeiro")
                                )
                );
    }

}
