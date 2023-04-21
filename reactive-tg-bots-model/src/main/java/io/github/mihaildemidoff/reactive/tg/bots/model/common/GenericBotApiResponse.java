package io.github.mihaildemidoff.reactive.tg.bots.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Generic bot api response.
 *
 * @param <T> type of query result.
 * @see <a href="https://core.telegram.org/bots/api#making-requests">Making requests</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericBotApiResponse<T> {

    /**
     * If 'ok' equals True, the request was successful and the result of the query can be found in the 'result' field.
     * In case of an unsuccessful request, 'ok' equals false and the error is explained in the 'description'.
     */
    @NotNull
    @JsonProperty("ok")
    private final Boolean ok;

    /**
     * Result of the query.
     */
    @JsonProperty("result")
    private final T result;

    /**
     * Error explanation.
     */
    @JsonProperty("description")
    private final String description;

    /**
     * Code of error in case if 'ok' is false , but its contents are subject to change in the future.
     */
    @JsonProperty("error_code")
    private final Long errorCode;

    /**
     * Detailed description of unsuccessful response.
     */
    @JsonProperty("parameters")
    private final ResponseParameters parameters;
}
