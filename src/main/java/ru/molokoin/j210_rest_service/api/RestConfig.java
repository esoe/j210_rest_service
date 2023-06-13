package ru.molokoin.j210_rest_service.api;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("api")
public class RestConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(RestClientService.class);
        resources.add(RestAddressService.class);
        return resources;
    }
}
    

