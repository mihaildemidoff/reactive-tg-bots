package io.github.mihaildemidoff.reactive.tg.bots.model.chat.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a chat member that owns the chat and has all administrator privileges.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberowner">ChatMemberOwner</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMemberOwner extends ChatMember {

    /**
     * The member's status in the chat, always “creator”
     */
    @NotNull
    @JsonProperty("status")
    private final ChatMemberStatus status = ChatMemberStatus.CREATOR;

    /**
     * True, if the user's presence in the chat is hidden
     */
    @NotNull
    @JsonProperty("is_anonymous")
    private final Boolean isAnonymous;

    /**
     * <b>Optional.</b><br>
     * Custom title for this user
     */
    @NotNull
    @JsonProperty("custom_title")
    private final String customTitle;

}
