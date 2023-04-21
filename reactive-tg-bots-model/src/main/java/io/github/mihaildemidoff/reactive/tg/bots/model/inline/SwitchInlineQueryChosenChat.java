package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents an inline button that switches the current user to inline mode in a chosen chat, with an
 * optional default inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#switchinlinequerychosenchat">SwitchInlineQueryChosenChat</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwitchInlineQueryChosenChat {

    /**
     * <b>Optional.</b><br>
     * The default inline query to be inserted in the input field. If left empty, only the bot's username will be
     * inserted
     */
    @JsonProperty("query")
    private final String query;

    /**
     * <b>Optional.</b><br>
     * True, if private chats with users can be chosen
     */
    @JsonProperty("allow_user_chats")
    private final Boolean allowUserChats;

    /**
     * <b>Optional.</b><br>
     * True, if private chats with bots can be chosen
     */
    @JsonProperty("allow_bot_chats")
    private final Boolean allowBotChats;

    /**
     * <b>Optional.</b><br>
     * True, if group and supergroup chats can be chosen
     */
    @JsonProperty("allow_group_chats")
    private final Boolean allowGroupChats;

    /**
     * <b>Optional.</b><br>
     * True, if channel chats can be chosen
     */
    @JsonProperty("allow_channel_chats")
    private final Boolean allowChannelChats;

}

