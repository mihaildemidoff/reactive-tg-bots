package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageentity">MessageEntity</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageEntity {

    /**
     * Type of the entity. Currently, can be “mention” (@username), “hashtag” (#hashtag), “cashtag” ($USD),
     * “bot_command” (/start@jobs_bot), “url” (https://telegram.org), “email” (do-not-reply@telegram.org),
     * “phone_number” (+1-212-555-0123), “bold” (bold text), “italic” (italic text),
     * “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message),
     * “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs),
     * “text_mention” (for users without usernames), “custom_emoji” (for inline custom emoji stickers)
     */
    @NotNull
    @JsonProperty("type")
    private final MessageEntityType type;

    /**
     * Offset in UTF-16 code units to the start of the entity
     */
    @NotNull
    @JsonProperty("offset")
    private final Long offset;

    /**
     * Length of the entity in UTF-16 code units
     */
    @NotNull
    @JsonProperty("length")
    private final Long length;

    /**
     * <b>Optional.</b><br>
     * For “text_link” only, URL that will be opened after user taps on the text
     */
    @JsonProperty("url")
    private final String url;

    /**
     * <b>Optional.</b><br>
     * For “text_mention” only, the mentioned user
     */
    @Valid
    @JsonProperty("user")
    private final User user;

    /**
     * <b>Optional.</b><br>
     * For “pre” only, the programming language of the entity text
     */
    @JsonProperty("language")
    private final String language;

    /**
     * <b>Optional.</b><br>
     * For “custom_emoji” only, unique identifier of the custom emoji.
     * Use getCustomEmojiStickers to get full information about the sticker
     */
    @JsonProperty("custom_emoji_id")
    private final String customEmojiId;

}
