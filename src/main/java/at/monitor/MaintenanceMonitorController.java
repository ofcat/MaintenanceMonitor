package at.monitor;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("")
public class MaintenanceMonitorController {
    private static String message = "red";

    @GET()
    @Path("/reset")
    public String resetMessage() {
        message = "red";
        return "message reset";
    }

    @GET()
    @Path("/set/{newMessage}")
    public String setMessage(@PathParam("newMessage") final String newMessage) {
        message = newMessage;
        return callStatus(message);

    }

    @GET()
    @Path("/get")
    public String getMessage() {
        return callStatus(message);
    }

    @GET
    //@Path("/status")
    @Produces({MediaType.TEXT_HTML})
    public String callStatus(String message) {

        if (message.equals("red")) // idea for starters
            return redStatus();
        if (message.equals("green"))
            return greenStatus();
        else
            return "null";
    }


    public String greenStatus() {

        return """
                <html>

                <head>
                <style>
                h1 {text-align: center;}
                p {text-align: center;}

                </style>
                    <meta charset="UTF-8">
                    <title>Maintenance Monitor</title>
                </head>

                <body style="background-color:green;">
                <br><br><br><br><br><br><br><br><br><br><br>
                    <h1>Maintenance Monitor</h1>
                    <p>status: ok</p>
                </body>

                </html>""";

    }


    public String redStatus() {

        return """
                <html>

                <head>
                <style>
                h1 {text-align: center;}
                p {text-align: center;}
                </style>
                    <meta charset="UTF-8">
                    <title>Maintenance Monitor</title>
                </head>

                <body style="background-color:red;">
                <br><br><br><br><br><br><br><br><br><br><br>
                    <h1>Maintenance Monitor</h1>
                    <p>status: error occurred</p>
                </body>

                </html>""";
    }


}


