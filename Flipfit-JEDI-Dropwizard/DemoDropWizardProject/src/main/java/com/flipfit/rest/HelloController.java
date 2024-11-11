package com.flipfit.rest;




import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-api")
@Produces(MediaType.APPLICATION_JSON)
public
class HelloController {
    @GET
    @Path("/hello")
    public String helloService() {

        return "This is my first service";
}
}