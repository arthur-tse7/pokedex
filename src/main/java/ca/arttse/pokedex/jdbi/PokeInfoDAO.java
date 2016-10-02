package ca.arttse.pokedex.jdbi;

import ca.arttse.pokedex.api.PokeInfo;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by Arthur Desktop on 2016-10-02.
 */
public interface PokeInfoDAO {

    @Mapper(PokeInfoMapper.class)
    @SqlQuery("SELECT id, identifier, primary_type, secondary_type, height, weight " +
            "FROM pokemon AS pokemon " +
            "JOIN (SELECT * FROM crosstab( " +
            "'SELECT pokemon_id, slot, identifier " +
            "FROM pokemon_types " +
            "INNER JOIN types " +
            "ON type_id = types.id " +
            "ORDER BY 1', " +
            "'SELECT DISTINCT slot " +
            "FROM pokemon_types " +
            "ORDER BY 1' " +
            ") as ct( " +
            "pokemon_id int, primary_type text, secondary_type text)) AS poketypes " +
            "ON pokemon.id = poketypes.pokemon_id " +
            "WHERE id = :id ")
    PokeInfo findPokemonById(@Bind("id") long id);
    
}
