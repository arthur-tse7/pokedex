package ca.arttse.pokedex.resources;

import ca.arttse.pokedex.api.PokeInfo;
import ca.arttse.pokedex.jdbi.PokeInfoDAO;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Arthur Desktop on 2016-09-25.
 */

@Path("/pokedex/{dexNo}")
@Produces(MediaType.APPLICATION_JSON)
public class PokedexResource {
    private PokeInfoDAO pokeInfoDAO;

    public PokedexResource(PokeInfoDAO pokeInfoDAO) {
        this.pokeInfoDAO = pokeInfoDAO;
    }

    @GET
    @Timed
    public PokeInfo getPokeInfo(@PathParam("dexNo") LongParam dexNo) {
        return pokeInfoDAO.findPokemonById(dexNo.get());
    }
}
