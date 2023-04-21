package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to close the bot instance before moving it from one local server to another.
 * You need to delete the webhook before calling this method to ensure that the bot isn't launched again after server
 * restart. The method will return error 429 in the first 10 minutes after the bot is launched.
 * Returns True on success. Requires no parameters.
 *
 * @see <a href="https://core.telegram.org/bots/api#close">close</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseMethod implements BooleanBotMethodDefinition {

    @Override
    public BotMethod getMethod() {
        return BotMethod.CLOSE;
    }
}
