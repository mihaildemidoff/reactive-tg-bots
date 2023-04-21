package io.github.mihaildemidoff.reactive.tg.bots.model.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;

/**
 * Instant deserializer, deserializes from epoch seconds to instant.
 */
public class InstantDeserializer extends StdDeserializer<Instant> {

    /**
     * Default constructor
     */
    protected InstantDeserializer() {
        super(Instant.class);
    }

    @Override
    public Instant deserialize(final JsonParser p,
                               final DeserializationContext ctxt) throws IOException {
        return Instant.ofEpochSecond(p.getLongValue());
    }

}
