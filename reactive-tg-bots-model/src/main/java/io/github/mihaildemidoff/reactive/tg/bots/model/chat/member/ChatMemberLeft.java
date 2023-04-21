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
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberleft">ChatMemberLeft</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMemberLeft extends ChatMember {

    /**
     * The member's status in the chat, always “left”
     */
    @NotNull
    @JsonProperty("status")
    private final ChatMemberStatus status = ChatMemberStatus.LEFT;

}
