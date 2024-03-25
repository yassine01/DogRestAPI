package me.lab.dogrestapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //There's an issue here when API is secured with basic auth ! Swagger dones't work correctly !


    @Value("${swagger.basicAuth.username}")
    private String basicAuthUsername;

    @Value("${swagger.basicAuth.password}")
    private String basicAuthPassword;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true)
                .securitySchemes(Collections.singletonList(apiKey()));

    }

    private SecurityScheme apiKey() {
        return new ApiKey("BasicAuth", "Authorization", "header");
    }

    @Bean
    public BasicAuth basicAuth() {
        return new BasicAuth(basicAuthUsername);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Collections.singletonList(
                new SecurityReference("BasicAuth", authorizationScopes));
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dog REST API",
                "This API returns / handle dog information (persisted in a H2 database).",
                "1.1",
                "localhost://8080/dogs",
                new Contact("yssn", "labs.me", "yssn@lab.me"),
                "License of API", "lab.me/license", Collections.emptyList()
        );
    }


}
