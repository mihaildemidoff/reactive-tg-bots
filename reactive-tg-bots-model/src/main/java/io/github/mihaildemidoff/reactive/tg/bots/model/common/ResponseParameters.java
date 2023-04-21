package io.github.mihaildemidoff.reactive.tg.bots.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Describes why a request was unsuccessful.
 *
 * @see <a href="https://core.telegram.org/bots/api#responseparameters">ResponseParameters</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseParameters {

    /**
     * <b>Optional.</b><br>
     * The group has been migrated to a supergroup with the specified identifier. This number may have more
     * than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for
     * storing this identifier.
     */
    @JsonProperty("migrate_to_chat_id")
    private final Long migrateToChatId;

    /**
     * <b>Optional.</b><br>
     * <p>
     * In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
     */
    @JsonProperty("retry_after")
    private final Long retryAfter;
}
