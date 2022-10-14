package com.restapi.auth;

import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.FluxSink;
//import reactor.core.publisher.Mono;

import java.util.Collections;

@Singleton
public class LoginAuthentication implements AuthenticationProvider {
    @Inject
    UserStore userStore;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        String username = authenticationRequest.getIdentity().toString();
        String password = authenticationRequest.getSecret().toString();
        if (password.equals(userStore.getUserPassword(username))) {
            return Publishers.just(AuthenticationResponse.success(username, Collections.singletonList(userStore.getUserRole(username))));
        } else {
            return Publishers.just(new AuthenticationFailed());
        }
    }
}

