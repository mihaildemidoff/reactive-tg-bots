package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Describes an inline message sent by a Web App on behalf of a user.
 *
 * @see <a href="https://core.telegram.org/bots/api#sentwebappmessage">SentWebAppMessage</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SentWebAppMessage implements BotApiResponse {

    /**
     * <b>Optional.</b><br>
     * Identifier of the sent inline message.
     * Available only if there is an inline keyboard attached to the message.
     */
    @JsonProperty("inline_message_id")
    private final String inlineMessageId;

}
