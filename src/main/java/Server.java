import at.monitor.MaintenanceMonitorController;
import at.monitor.WebServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server {
    public static void main(final String... args) {
        System.out.println("Starting http server");

        final var resourceConfig = new ResourceConfig(MaintenanceMonitorController.class, WebServer.class);

        // taken from https://raw.githubusercontent.com/kienboec/SWLCM-Samples/main/src/main/java/Main.java

        final var server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), resourceConfig);

        System.out.println("Server started");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.stop(0);
        System.out.println("Server stopped");
    }
}
