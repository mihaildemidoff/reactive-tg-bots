package io.github.mihaildemidoff.reactive.tg.bots.model.reply.keyboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.ChatAdministratorRights;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object defines the criteria used to request a suitable chat.
 * The identifier of the selected chat will be shared with the bot when the corresponding button is pressed.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestchat">KeyboardButtonRequestChat</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyboardButtonRequestChat {

    /**
     * Signed 32-bit identifier of the request, which will be received back in the ChatShared object.
     * Must be unique within the message
     */
    @NotNull
    @JsonProperty("request_id")
    private final Long requestId;

    /**
     * Pass True to request a channel chat, pass False to request a group or a supergroup chat.
     */
    @NotNull
    @JsonProperty("chat_is_channel")
    private final Boolean chatIsChannel;

    /**
     * <b>Optional.</b><br>
     * Pass True to request a forum supergroup, pass False to request a non-forum chat.
     * If not specified, no additional restrictions are applied.
     */
    @JsonProperty("chat_is_forum")
    private final Boolean chatIsForum;

    /**
     * <b>Optional.</b><br>
     * Pass True to request a supergroup or a channel with a username, pass False to request a chat without
     * a username. If not specified, no additional restrictions are applied.
     */
    @JsonProperty("chat_has_username")
    private final Boolean chatHasUsername;

    /**
     * <b>Optional.</b><br>
     * Pass True to request a chat owned by the user. Otherwise, no additional restrictions are applied.
     */
    @JsonProperty("chat_is_created")
    private final Boolean chatIsCreated;

    /**
     * <b>Optional.</b><br>
     * A JSON-serialized object listing the required administrator rights of the user in the chat.
     * The rights must be a superset of bot_administrator_rights.
     * If not specified, no additional restrictions are applied.
     */
    @Valid
    @JsonProperty("user_administrator_rights")
    private final ChatAdministratorRights userAdministratorRights;

    /**
     * <b>Optional.</b><br>
     * A JSON-serialized object listing the required administrator rights of the bot in the chat.
     * The rights must be a subset of user_administrator_rights.
     * If not specified, no additional restrictions are applied.
     */
    @Valid
    @JsonProperty("bot_administrator_rights")
    private final ChatAdministratorRights botAdministratorRights;

    /**
     * <b>Optional.</b><br>
     * Pass True to request a chat with the bot as a member.
     * Otherwise, no additional restrictions are applied.
     */
    @JsonProperty("bot_is_member")
    private final Boolean botIsMember;

}
