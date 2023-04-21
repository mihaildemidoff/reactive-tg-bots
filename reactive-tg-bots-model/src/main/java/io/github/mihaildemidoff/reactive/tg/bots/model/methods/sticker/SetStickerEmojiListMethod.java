package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to change the list of emoji assigned to a regular or custom emoji sticker.
 * The sticker must belong to a sticker set created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickeremojilist">setStickerEmojiList</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStickerEmojiListMethod implements BooleanBotMethodDefinition {

    /**
     * File identifier of the sticker
     */
    @NotNull
    @JsonProperty("sticker")
    private final String sticker;

    /**
     * A JSON-serialized list of 1-20 emoji associated with the sticker
     */
    // TODO: add emoji validation
    @Size(min = 1, max = 20)
    @NotNull
    @JsonProperty("emoji_list")
    private final List<String> emojiList;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_STICKER_EMOJI_LIST;
    }
}
