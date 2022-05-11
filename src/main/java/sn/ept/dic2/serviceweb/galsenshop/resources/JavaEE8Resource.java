package sn.ept.dic2.serviceweb.galsenshop.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("hello")
public class JavaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("Hello World, here is my first web service with JEE")
                .status(Response.Status.OK)
                .build();
    }
}
