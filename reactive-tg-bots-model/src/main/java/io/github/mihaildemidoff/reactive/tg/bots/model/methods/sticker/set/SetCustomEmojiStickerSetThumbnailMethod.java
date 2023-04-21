package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to set the thumbnail of a custom emoji sticker set.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">
 * setCustomEmojiStickerSetThumbnail</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetCustomEmojiStickerSetThumbnailMethod implements BooleanBotMethodDefinition {

    /**
     * Sticker set name
     */
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * Custom emoji identifier of a sticker from the sticker set;
     * pass an empty string to drop the thumbnail and use the first sticker as the thumbnail.
     */
    // TODO: add emoji validation
    @JsonProperty("custom_emoji_id")
    private final String custom_emoji_id;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL;
    }
}
