package at.monitor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class MaintenanceMonitorController {

    @GET
    public String test() {
        return "test";
    }
}
