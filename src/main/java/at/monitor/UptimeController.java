package at.monitor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/uptime")
public class UptimeController {

    @GET
    @Path("/{uptime}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateUptime(@PathParam("uptime") double uptime) {
        double minutesOfMonth = 60*24*30;
        double definedUptimeInPercent = uptime / 100;
        double uptimeInMinutes = minutesOfMonth * definedUptimeInPercent;
        return String.format("%.2f", uptimeInMinutes);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateUptime() {
        return this.calculateUptime(99.95);
    }
}
