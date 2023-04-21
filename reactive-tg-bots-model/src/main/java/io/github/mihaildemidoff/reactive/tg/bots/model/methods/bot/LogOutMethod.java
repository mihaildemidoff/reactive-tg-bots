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
 * Use this method to log out from the cloud Bot API server before launching the bot locally.
 * You must log out the bot before running it locally, otherwise there is no guarantee that the bot will receive
 * updates. After a successful call, you can immediately log in on a local server, but will not be able to log in back
 * to the cloud Bot API server for 10 minutes. Returns True on success. Requires no parameters.
 *
 * @see <a href="https://core.telegram.org/bots/api#logout">logOut</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogOutMethod implements BooleanBotMethodDefinition {

    @Override
    public BotMethod getMethod() {
        return BotMethod.LOG_OUT;
    }
}
