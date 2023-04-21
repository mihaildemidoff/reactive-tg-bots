package io.github.mihaildemidoff.reactive.tg.bots.model.reply.keyboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents one button of the reply keyboard. For simple text buttons, String can be used instead of this
 * object to specify the button text. The optional fields web_app, request_user, request_chat, request_contact,
 * request_location, and request_poll are mutually exclusive.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">KeyboardButton</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyboardButton {

    /**
     * Text of the button. If none of the optional fields are used, it will be sent as a message when the button is
     * pressed
     */
    @NotNull
    @JsonProperty("text")
    private final String text;

    /**
     * <b>Optional.</b><br>
     * If specified, pressing the button will open a list of suitable users.
     * Tapping on any user will send their identifier to the bot in a “user_shared” service message.
     * Available in private chats only.
     */
    @Valid
    @JsonProperty("request_user")
    private final KeyboardButtonRequestUser requestUser;

    /**
     * <b>Optional.</b><br>
     * If specified, pressing the button will open a list of suitable chats.
     * Tapping on a chat will send its identifier to the bot in a “chat_shared” service message.
     * Available in private chats only.
     */
    @Valid
    @JsonProperty("request_chat")
    private final KeyboardButtonRequestChat requestChat;

    /**
     * <b>Optional.</b><br>
     * If True, the user's phone number will be sent as a contact when the button is pressed.
     * Available in private chats only.
     */
    @JsonProperty("request_contact")
    private final Boolean requestContact;

    /**
     * <b>Optional.</b><br>
     * If True, the user's current location will be sent when the button is pressed.
     * Available in private chats only.
     */
    @JsonProperty("request_location")
    private final String requestLocation;

    /**
     * <b>Optional.</b><br>
     * If specified, the user will be asked to create a poll and send it to the bot when the button is pressed.
     * Available in private chats only.
     */
    @JsonProperty("request_poll")
    private final String requestPoll;

    /**
     * <b>Optional.</b><br>
     * If specified, the described Web App will be launched when the button is pressed.
     * The Web App will be able to send a “web_app_data” service message.
     * Available in private chats only.
     */
    @JsonProperty("web_app")
    private final String webApp;

}
