package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class VersionResource {

    @ConfigProperty(name = "quarkus.application.version")
    String version;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return """
                <!DOCTYPE html>
                <html>
                <head><title>simple-webapp</title></head>
                <body>
                <h1>simple-webapp Version %s</h1>
                </body>
                </html>
                """.formatted(version);
    }
}
