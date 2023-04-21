package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.ban;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to unban a previously banned user in a supergroup or channel. The user will not return to the group
 * or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work.
 * By default, this method guarantees that after the call the user is not a member of the chat, but will be able to
 * join it. So if the user is a member of the chat they will also be removed from the chat. If you don't want this, use
 * the parameter only_if_banned. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unbanchatmember">unbanChatMember</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnbanChatMemberMethod implements BooleanBotMethodDefinition {

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
     * Do nothing if the user is not banned
     */
    @JsonProperty("only_if_banned")
    private final Boolean onlyIfBanned;


    @Override
    public BotMethod getMethod() {
        return BotMethod.UNBAN_CHAT_MEMBER;
    }
}
