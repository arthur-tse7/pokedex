package ca.arttse.pokedex.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Arthur Desktop on 2016-10-02.
 */
public class TypeSeralizer extends JsonSerializer<String[]> {
    @Override
    public void serialize(String[] types, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        if (types[0] != null)
            gen.writeStringField("primary", types[0]);
        if (types[1] != null)
            gen.writeStringField("secondary", types[1]);
        gen.writeEndObject();
    }
}
