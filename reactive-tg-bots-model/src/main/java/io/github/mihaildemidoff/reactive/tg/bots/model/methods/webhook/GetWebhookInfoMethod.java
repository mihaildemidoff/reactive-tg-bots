package io.github.mihaildemidoff.reactive.tg.bots.model.methods.webhook;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.webhook.WebhookInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get current webhook status. Requires no parameters.
 * On success, returns a {@link WebhookInfo} object.
 * If the bot is using getUpdates, will return an object with the url field empty.
 *
 * @see <a href="https://core.telegram.org/bots/api#getwebhookinfo">getWebhookInfo</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWebhookInfoMethod implements TypedBotMethodDefinition<WebhookInfo> {

    @Override
    public TypeReference<GenericBotApiResponse<WebhookInfo>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_WEBHOOK_INFO;
    }
}
