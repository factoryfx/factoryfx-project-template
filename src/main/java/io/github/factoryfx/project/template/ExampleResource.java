package io.github.factoryfx.project.template;

import java.lang.String;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Example jersey REST resource
 */
@Path("/")
public class ExampleResource {
    private final String text;
    public ExampleResource(String text) {
        this.text=text;
    }

    @GET
    public String get() {
        return text;
    }
}
