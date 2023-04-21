package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.member.ChatMember;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * This object represents changes in the status of a chat member.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberupdated">ChatMemberUpdated</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMemberUpdated {

    /**
     * Chat the user belongs to
     */
    @Valid
    @NotNull
    @JsonProperty("chat")
    private final Chat chat;

    /**
     * Performer of the action, which resulted in the change
     */
    @Valid
    @NotNull
    @JsonProperty("from")
    private final User from;

    /**
     * Date the change was done in Unix time
     */
    @NotNull
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("date")
    private final Instant date;

    /**
     * Previous information about the chat member
     */
    @Valid
    @NotNull
    @JsonProperty("old_chat_member")
    private final ChatMember oldChatMember;

    /**
     * New information about the chat member
     */
    @Valid
    @NotNull
    @JsonProperty("new_chat_member")
    private final ChatMember newChatMember;

    /**
     * <b>Optional.</b><br>
     * Chat invite link, which was used by the user to join the chat; for joining by invite link events only.
     */
    @Valid
    @JsonProperty("invite_link")
    private final ChatInviteLink inviteLink;

    /**
     * <b>Optional.</b><br>
     * True, if the user joined the chat via a chat folder invite link
     */
    @JsonProperty("via_chat_folder_invite_link")
    private final Boolean viaChatFolderInviteLink;

}
