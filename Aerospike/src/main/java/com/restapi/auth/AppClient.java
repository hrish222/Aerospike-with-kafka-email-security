package com.restapi.auth;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;
import static io.micronaut.http.MediaType.TEXT_PLAIN;

/**
 * The interface App client.
 */
@Client("/")
public interface AppClient {

    /**
     * Login bearer access refresh token.
     *
     * @param credentials the credentials
     * @return the bearer access refresh token
     */
    @Post("/login")
    BearerAccessRefreshToken login(@Body UsernamePasswordCredentials credentials);

    /**
     * Home string.
     *
     * @param authorization the authorization
     * @return the string
     */
    @Consumes(TEXT_PLAIN)
    @Get
    String home(@Header(AUTHORIZATION) String authorization);
}