package io.github.mihaildemidoff.reactive.tg.bots.core.http;

import lombok.experimental.UtilityClass;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

/**
 * Http client builder
 */
@UtilityClass
public class HttpClientBuilder {

    /**
     * Default http client.
     *
     * @param responseTimeout response timeout used for each request
     * @return default http client
     */
    public static HttpClient defaultHttpClient(final Duration responseTimeout) {
        return HttpClient
                .create()
                .responseTimeout(responseTimeout);
    }

}
