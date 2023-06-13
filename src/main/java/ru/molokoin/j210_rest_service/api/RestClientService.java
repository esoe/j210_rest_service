package ru.molokoin.j210_rest_service.api;

import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ru.molokoin.j210_rest_service.ModelClient;
import ru.molokoin.j210_rest_service.services.RepositoryFace;

@Stateless
@Path("clients")
public class RestClientService {

    @EJB
    private RepositoryFace repository;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Collection<ModelClient> getAll(){
        return repository.findAll(ModelClient.class);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public ModelClient getClient(@PathParam("id") Integer id){
        return repository.findById(ModelClient.class, id);
    }
    
}
