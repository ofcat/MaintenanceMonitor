package at.monitor;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public class MaintenanceMonitorController {
    private static String message = "-";

    @GET()
    @Path("/reset")
    public Response resetMessage() {
        message = "-";
        return Response.ok().entity("Message reset").build();
    }

    @GET()
    @Path("/set/{newMessage}")
    public Response setMessage(@PathParam("newMessage") final String newMessage) {
        message = newMessage;
        return Response.ok().entity("New message: " + message).build();
    }

    @GET()
    @Path("/get")
    @Produces(MediaType.TEXT_HTML)
    public String getMessage() {
        return message;
    }
}
