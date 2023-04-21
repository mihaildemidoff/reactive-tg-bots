package io.github.mihaildemidoff.reactive.tg.bots.model.jackson;

import com.fasterxml.jackson.core.JsonParser;
import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class InstantDeserializerTest {

    @InjectMocks
    private InstantDeserializer instantDeserializer;

    @Test
    void testDeserialization() throws IOException {
        final JsonParser parser = Mockito.mock(JsonParser.class);
        final long seconds = RandomUtils.nextLong(100, 100000);
        Mockito.when(parser.getLongValue())
                .thenReturn(seconds);
        assertThat(instantDeserializer.deserialize(parser, null), CoreMatchers.is(Instant.ofEpochSecond(seconds)));
    }

}
