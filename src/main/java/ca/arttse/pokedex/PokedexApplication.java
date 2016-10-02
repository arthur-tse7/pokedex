package ca.arttse.pokedex;

import ca.arttse.pokedex.jdbi.PokeInfoDAO;
import ca.arttse.pokedex.resources.PokedexResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by Arthur Desktop on 2016-09-25.
 */
public class PokedexApplication extends Application<PokedexConfiguration> {

    public static void main(String[] args) throws Exception {
        new PokedexApplication().run(args);
    }

    @Override
    public String getName() {
        return "pokedex";
    }

    @Override
    public void initialize(Bootstrap<PokedexConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(PokedexConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final PokeInfoDAO dao = jdbi.onDemand(PokeInfoDAO.class);

        environment.jersey().register(new PokedexResource(dao));
    }
}
