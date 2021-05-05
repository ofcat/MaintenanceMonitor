package at.monitor;

import jakarta.ws.rs.*;

@Path("/api")
public class MaintenanceMonitorController {
    private static String message = "red";

    @GET()
    @Path("/reset")
    public String resetMessage() {
        message = "red";
        System.out.println("reset: " + message);
        return "message reset";
    }

    @GET()
    @Path("/set/{newMessage}")
    public String setMessage(@PathParam("newMessage") final String newMessage) {
        message = newMessage;
        System.out.println("set: " + message);
        return message;
    }

    @GET()
    @Path("/get")
    public String getMessage() {
        System.out.println("get: " + message);
        return message;
    }
}
