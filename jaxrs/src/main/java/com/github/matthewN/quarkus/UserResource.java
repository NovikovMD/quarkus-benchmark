package com.github.matthewN.quarkus;

import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @ConfigProperty(name = "page.size", defaultValue = "20")
    Integer pageSize;

    @GET
    @Path("hello")
    public String hello() {
        return "hello";
    }

    @GET
    public List<User> findAll() {
        int usersCount = 100_000;
        int maxPage = usersCount / pageSize;
        int pageIndex = Math.abs(ThreadLocalRandom.current().nextInt()) % maxPage;
        return User.findAll(Sort.ascending("firstname"))
            .page(pageIndex, pageSize)
            .list();
    }

    @POST
    @Transactional
    public void add(User user) {
        user.persist();
    }
}