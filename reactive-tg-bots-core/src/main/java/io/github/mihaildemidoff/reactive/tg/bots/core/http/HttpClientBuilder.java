package io.github.mihaildemidoff.reactive.tg.bots.core.http;

import lombok.experimental.UtilityClass;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.logging.ReactorNettyHttpMessageLogFactory;

import java.time.Duration;

/**
 * Http client builder
 */
@UtilityClass
public class HttpClientBuilder {

    /**
     * Default http client.
     *
     * @param baseUrl         base url to telegram server
     * @param responseTimeout response timeout used for each request
     * @return default http client
     */
    public static HttpClient defaultHttpClient(final String baseUrl,
                                               final Duration responseTimeout) {
        return HttpClient
                .create()
                .baseUrl(baseUrl)
                .wiretap(true)
                .httpMessageLogFactory(new ReactorNettyHttpMessageLogFactory())
                .responseTimeout(responseTimeout);
    }

}
