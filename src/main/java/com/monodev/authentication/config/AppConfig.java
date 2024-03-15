package com.monodev.authentication.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Value("${monodev.openapi.dev-url}")
    private String devUrl;
  
    @Value("${monodev.openapi.prod-url}")
    private String prodUrl;
  
    @Bean
    public OpenAPI myOpenAPI() {
      Server devServer = new Server();
      devServer.setUrl(devUrl);
      devServer.setDescription("Server URL in Development environment");
  
      Server prodServer = new Server();
      prodServer.setUrl(prodUrl);
      prodServer.setDescription("Server URL in Production environment");
  
      Contact contact = new Contact();
      contact.setEmail("monodev@gmail.com");
      contact.setName("monodev");
      contact.setUrl("https://www.monodev.com");
  
      License mitLicense = new License().name("MIT License").url("https://monodev.com/licenses/mit/");
  
      Info info = new Info()
          .title("Authenticación API")
          .version("1.0")
          .contact(contact)
          .description("This API exposes endpoints to manage tutorials.")
          .termsOfService("https://www.monodev.com/terms")
          .license(mitLicense);
  
      SecurityScheme securityScheme = new SecurityScheme()
          .type(SecurityScheme.Type.HTTP)
          .scheme("bearer")
          .bearerFormat("JWT");
  
      SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");
  
      return new OpenAPI()
          .info(info)
          .servers(List.of(devServer, prodServer))
          .components(new io.swagger.v3.oas.models.Components().addSecuritySchemes("bearerAuth", securityScheme))
          .addSecurityItem(securityRequirement);
    }

   
}
