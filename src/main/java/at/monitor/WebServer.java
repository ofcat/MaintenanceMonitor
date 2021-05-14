package at.monitor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path( "/" )
public class WebServer {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getPage()
    {
        try {
            var path = Paths.get("src/main/resources/MaintenanceMonitor.html");
            System.out.println(path.toAbsolutePath());
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
