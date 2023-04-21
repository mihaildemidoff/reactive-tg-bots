package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Describes data sent from a Web App to the bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#webappdata">WebAppData</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebAppData {

    /**
     * The data. Be aware that a bad client can send arbitrary data in this field.
     */
    @NotNull
    @JsonProperty("data")
    private final String data;

    /**
     * Text of the web_app keyboard button from which the Web App was opened. Be aware that a bad client can send
     * arbitrary data in this field.
     */
    @NotNull
    @JsonProperty("button_text")
    private final String buttonText;

}
