package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * A simple method for testing your bot's authentication token. Requires no parameters.
 * Returns basic information about the bot in form of
 * a {@link io.github.mihaildemidoff.reactive.tg.bots.model.user.User} object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getme">getMe</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMeMethod implements TypedBotMethodDefinition<User> {

    @Override
    public TypeReference<GenericBotApiResponse<User>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_ME;
    }
}
