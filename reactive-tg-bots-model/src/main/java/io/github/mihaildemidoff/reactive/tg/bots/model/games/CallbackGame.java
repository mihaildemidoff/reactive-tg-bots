package io.github.mihaildemidoff.reactive.tg.bots.model.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * A placeholder, currently holds no information. Use BotFather to set up your game.
 *
 * @see <a href="https://core.telegram.org/bots/api#callbackgame">CallbackGame</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackGame {
}
