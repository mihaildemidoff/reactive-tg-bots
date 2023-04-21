package io.github.mihaildemidoff.reactive.tg.bots.model.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoField;

/**
 * Instant serializer, serializes from instant to epoch seconds.
 */
public class InstantSerializer extends StdSerializer<Instant> {

    /**
     * Default constructor
     */
    protected InstantSerializer() {
        super(Instant.class);
    }

    @Override
    public void serialize(final Instant value,
                          final JsonGenerator gen,
                          final SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getLong(ChronoField.INSTANT_SECONDS));
    }
}
