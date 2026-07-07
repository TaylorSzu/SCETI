package com.taylorsz.sceti.api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Nome da aplic")
            .version("1.0.0")
            .description("A tal da descrição")
            .contact(new Contact()
                .name("Nome do contato")
                .email("xpto.123@gmail.com")
                .url("https://github.com/fulano")
                .url("https://www.linkedin.com/in/fulano"))
            .license(new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT")))
        .servers(List.of(
            new Server().url("http://localhost:8080").description("Local")));
  }

}
