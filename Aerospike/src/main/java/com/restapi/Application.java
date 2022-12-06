package com.restapi;



import io.micronaut.context.ApplicationContext;
import io.micronaut.openapi.annotation.OpenAPIInclude;
import io.micronaut.runtime.Micronaut;
import io.micronaut.security.endpoints.LoginController;
import io.micronaut.security.endpoints.LogoutController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * The type Application.
 */
@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
@OpenAPIDefinition(
        info = @Info(
                title = "aerospike",
                version = "0.0",
                description = "Hrishi API",
                license = @License(name = "Apache 2.0", url = "https://hrishi.bar"),
                contact = @Contact(url = "https://gigantic-server.com", name = "Hrishikesh Nalavade", email = "hrishikeshnalavade22@gmail.com")
        )
)
@OpenAPIInclude(
        classes = {LoginController.class, LogoutController.class},
        tags = @Tag(name = "Authentication")
)

public class Application {
    private static  final Logger LOGGER = LogManager.getLogManager().getLogger(Application.class.getName());
    private static ApplicationContext context;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        context=Micronaut.run(Application.class, args);
    }

    /**
     * Gets application context.
     *
     * @return the application context
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
