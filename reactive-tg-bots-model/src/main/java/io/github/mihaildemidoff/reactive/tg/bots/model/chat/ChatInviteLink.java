package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * Represents an invite link for a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatinvitelink">ChatInviteLink</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatInviteLink implements BotApiResponse {

    /**
     * The invite link. If the link was created by another chat administrator, then the second part of the link will be
     * replaced with “…”.
     */
    @NotNull
    @JsonProperty("invite_link")
    private final String inviteLink;

    /**
     * Creator of the link
     */
    @Valid
    @NotNull
    @JsonProperty("creator")
    private final User creator;

    /**
     * True, if users joining the chat via the link need to be approved by chat administrators
     */
    @NotNull
    @JsonProperty("creates_join_request")
    private final Boolean createsJoinRequest;

    /**
     * True, if the link is primary
     */
    @NotNull
    @JsonProperty("is_primary")
    private final Boolean isPrimary;

    /**
     * True, if the link is revoked
     */
    @NotNull
    @JsonProperty("is_revoked")
    private final Boolean isRevoked;

    /**
     * <b>Optional.</b><br>
     * Invite link name
     */
    @JsonProperty("name")
    private final String name;

    /**
     * <b>Optional.</b><br>
     * Point in time (Unix timestamp) when the link will expire or has been expired
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("expire_date")
    private final Instant expireDate;

    /**
     * <b>Optional.</b><br>
     * The maximum number of users that can be members of the chat simultaneously after joining the chat via
     * this invite link; 1-99999
     */
    @Size(min = 1, max = 99999)
    @JsonProperty("member_limit")
    private final Long memberLimit;

    /**
     * <b>Optional.</b><br>
     * Number of pending join requests created using this link
     */
    @JsonProperty("pending_join_request_count")
    private final Long pendingJoinRequestCount;

}
