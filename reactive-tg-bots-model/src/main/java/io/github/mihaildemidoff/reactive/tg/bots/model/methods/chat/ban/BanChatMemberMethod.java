package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.ban;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the
 * user will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
 * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#banchatmember">banChatMember</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BanChatMemberMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier of the target user
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds
     * from the current time they are considered to be banned forever. Applied for supergroups and channels only.
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("until_date")
    private final Instant untilDate;

    /**
     * Pass True to delete all messages from the chat for the user that is being removed. If False, the user will be
     * able to see messages in the group that were sent before the user was removed.
     * Always True for supergroups and channels.
     */
    @JsonProperty("revoke_messages")
    private final Boolean revokeMessages;

    @Override
    public BotMethod getMethod() {
        return BotMethod.BAN_CHAT_MEMBER;
    }
}
