package ca.arttse.pokedex;

import ca.arttse.pokedex.health.TemplateHealthCheck;
import ca.arttse.pokedex.resources.PokedexResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Arthur Desktop on 2016-09-25.
 */
public class PokedexApplication extends Application<PokedexConfiguration> {

    public static void main(String[] args) throws Exception {
        new PokedexApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<PokedexConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(PokedexConfiguration configuration, Environment environment) throws Exception {
        final PokedexResource resource = new PokedexResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
