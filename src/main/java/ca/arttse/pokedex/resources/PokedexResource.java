package ca.arttse.pokedex.resources;

import ca.arttse.pokedex.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Arthur Desktop on 2016-09-25.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class PokedexResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public PokedexResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
