package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a service message about a user allowing a bot to write messages after adding the bot to the
 * attachment menu or launching a Web App from a link.
 *
 * @see <a href="https://core.telegram.org/bots/api#writeaccessallowed">WriteAccessAllowed</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class WriteAccessAllowed {
    /**
     * <b>Optional.</b><br>
     * Name of the Web App which was launched from a link
     */
    @JsonProperty("web_app_name")
    private final String webAppName;
}
