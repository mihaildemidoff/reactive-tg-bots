package io.github.mihaildemidoff.reactive.tg.bots.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a Telegram user or bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#user">User</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements BotApiResponse {

    /**
     * Unique identifier for this user or bot. This number may have more than 32 significant bits and some programming
     * languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     * 64-bit integer or double-precision float type are safe for storing this identifier.
     */
    @NotNull
    @JsonProperty("id")
    private final Long id;

    /**
     * True, if this user is a bot
     */
    @NotNull
    @JsonProperty("is_null")
    private final Boolean isNull;

    /**
     * User's or bot's first name
     */
    @NotNull
    @JsonProperty("first_name")
    private final String firstName;

    /**
     * <b>Optional.</b><br>
     * User's or bot's last name
     */
    @JsonProperty("last_name")
    private final String lastName;

    /**
     * <b>Optional.</b><br>
     * User's or bot's username
     */
    @JsonProperty("username")
    private final String username;

    /**
     * <b>Optional.</b><br>
     * <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language
     */
    @JsonProperty("language_code")
    private final String languageCode;

    /**
     * <b>Optional.</b><br>
     * True, if this user is a Telegram Premium user
     */
    @JsonProperty("is_premium")
    private final Boolean isPremium;

    /**
     * <b>Optional.</b><br>
     * True, if this user added the bot to the attachment menu
     */
    @JsonProperty("added_to_attachment_menu")
    private final Boolean addedToAttachmentMenu;

    /**
     * <b>Optional.</b><br>
     * True, if the bot can be invited to groups. Returned only in getMe.
     */
    @JsonProperty("can_join_groups")
    private final Boolean canJoinGroups;

    /**
     * <b>Optional.</b><br>
     * True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    @JsonProperty("can_read_all_group_messages")
    private final Boolean canReadAllGroupMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the bot supports inline queries. Returned only in getMe.
     */
    @JsonProperty("supports_inline_queries")
    private final Boolean supportsInlineQueries;

}
