package ca.arttse.pokedex.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dropwizard.jackson.JsonSnakeCase;

/**
 * Created by Arthur Desktop on 2016-09-25.
 */
@JsonSnakeCase
public class PokeInfo {
    private long dexNo;
    private String name;
    @JsonSerialize(using=TypeSeralizer.class)
    private String[] types;
    private long height;
    private long weight;

    public PokeInfo() {
        // Jackson deserialization
    }

    private PokeInfo(PokeInfoBuilder builder) {
        this.dexNo = builder.dexNo;
        this.name = builder.name;
        this.types = builder.types;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    @JsonProperty
    public long getDexNo() {
        return dexNo;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String[] getTypes() {
        return types;
    }

    @JsonProperty
    public long getHeight() {
        return height;
    }

    @JsonProperty
    public long getWeight() {
        return weight;
    }

    public static class PokeInfoBuilder {
        private long dexNo;
        private String name;
        private String[] types;
        private long height;
        private long weight;

        public PokeInfoBuilder(long dexNo, String name) {
            this.dexNo = dexNo;
            this.name = name;
        }

        public PokeInfoBuilder types(String[] types) {
            this.types = types;
            return this;
        }

        public PokeInfoBuilder height(long height) {
            this.height = height;
            return this;
        }

        public PokeInfoBuilder weight(long weight) {
            this.weight = weight;
            return this;
        }

        public PokeInfo build() {
            return new PokeInfo(this);
        }
    }
}
