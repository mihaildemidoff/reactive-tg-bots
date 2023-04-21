package io.github.mihaildemidoff.reactive.tg.bots.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents the bot's description.
 *
 * @see <a href="https://core.telegram.org/bots/api#botdescription">BotDescription</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotDescription implements BotApiResponse {

    /**
     * The bot's description
     */
    @NotNull
    @JsonProperty("description")
    private final String description;

}
