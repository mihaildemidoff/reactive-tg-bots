package io.github.mihaildemidoff.reactive.tg.bots.core.http;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class HttpClientBuilderTest {

    @Test
    void testDefaultHttpClient() {
        final int duration = RandomUtils.nextInt(1, 10);
        final HttpClient result = HttpClientBuilder
                .defaultHttpClient(RandomStringUtils.randomAlphabetic(10), Duration.ofSeconds(duration));
        assertThat(result, CoreMatchers.notNullValue());
    }

}
