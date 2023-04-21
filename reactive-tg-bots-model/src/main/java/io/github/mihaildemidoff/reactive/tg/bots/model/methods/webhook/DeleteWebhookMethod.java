package io.github.mihaildemidoff.reactive.tg.bots.model.methods.webhook;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to remove webhook integration if you decide to switch back to getUpdates.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletewebhook">deleteWebhook</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteWebhookMethod implements BooleanBotMethodDefinition {

    /**
     * Pass True to drop all pending updates
     */
    @JsonProperty("drop_pending_updates")
    private final Boolean dropPendingUpdates;


    @Override
    public BotMethod getMethod() {
        return BotMethod.DELETE_WEBHOOK;
    }
}
