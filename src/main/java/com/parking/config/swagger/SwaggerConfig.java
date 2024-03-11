package com.parking.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.apache.catalina.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI baseOpenApi(){

        Contact contact = new Contact();

        contact.setEmail("hebertsantosdeveloper@gmail.com");
        contact.setName("Hebert Conceição Dos Santos");
        contact.setUrl("https://ihebert.vercel.app/");

        Info info = new Info()
                .title("Api anúncio de vagas de estacionamento")
                .version("1.0")
                .description("Sistema onde é possivel adicionar anúncios de espaços, e cadastrar veiculos.")
                .contact(contact);

        return new OpenAPI()
                .info(info);

    }
}
