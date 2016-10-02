package ca.arttse.pokedex.jdbi;

import ca.arttse.pokedex.api.PokeInfo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Arthur Desktop on 2016-10-02.
 */
public class PokeInfoMapper implements ResultSetMapper<PokeInfo> {
    @Override
    public PokeInfo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        String[] types = {r.getString("primary_type"), r.getString("secondary_type")};

        return new PokeInfo.PokeInfoBuilder(r.getLong("id"), r.getString("identifier"))
                .types(types)
                .height(r.getLong("height"))
                .weight(r.getLong("weight"))
                .build();
    }
}
