package io.github.mihaildemidoff.reactive.tg.bots.model.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.Instant;

@ExtendWith(MockitoExtension.class)
class InstantSerializerTest {

    @InjectMocks
    private InstantSerializer instantSerializer;

    @Test
    void testSerialization() throws IOException {
        final JsonGenerator generator = Mockito.mock(JsonGenerator.class);
        final long seconds = RandomUtils.nextLong(100, 100000);
        final Instant value = Instant.ofEpochSecond(seconds);
        instantSerializer.serialize(value, generator, null);
        Mockito.verify(generator, Mockito.times(1))
                .writeNumber(ArgumentMatchers.eq(seconds));
    }

}
