package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldController {

    @GET
    public String getMessage()  {
        System.out.println("hello");
        return "Hello World : Reema";
    }
}
