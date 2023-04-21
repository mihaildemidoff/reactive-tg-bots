package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
 * Represents a join request sent to a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatjoinrequest">ChatJoinRequest</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatJoinRequest {

    /**
     * Chat to which the request was sent
     */
    @Valid
    @NotNull
    @JsonProperty("chat")
    private final Chat chat;

    /**
     * User that sent the join request
     */
    @Valid
    @NotNull
    @JsonProperty("from")
    private final User from;

    /**
     * Identifier of a private chat with the user who sent the join request.
     * This number may have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float
     * type are safe for storing this identifier. The bot can use this identifier for 24 hours to send messages until
     * the join request is processed, assuming no other administrator contacted the user.
     */
    @NotNull
    @JsonProperty("user_chat_id")
    private final Long userChatId;

    /**
     * Date the request was sent in Unix time
     */
    @NotNull
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("date")
    private final Instant date;

    /**
     * <b>Optional.</b><br>
     * Bio of the user.
     */
    @JsonProperty("bio")
    private final String bio;

    /**
     * <b>Optional.</b><br>
     * Chat invite link that was used by the user to send the join request
     */
    @Valid
    @JsonProperty("invite_link")
    private final ChatInviteLink inviteLink;
}
