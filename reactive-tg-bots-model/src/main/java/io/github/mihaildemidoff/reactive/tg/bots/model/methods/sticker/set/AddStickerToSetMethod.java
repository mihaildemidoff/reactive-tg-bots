package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.InputSticker;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Optional;

/**
 * Use this method to add a new sticker to a set created by the bot.
 * The format of the added sticker must match the format of the other stickers in the set.
 * Emoji sticker sets can have up to 200 stickers.
 * Animated and video sticker sets can have up to 50 stickers.
 * Static sticker sets can have up to 120 stickers.
 * Returns True on success
 *
 * @see <a href="https://core.telegram.org/bots/api#addstickertoset">addStickerToSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddStickerToSetMethod implements BooleanBotMediaMethodDefinition {

    /**
     * User identifier of sticker set owner
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * Sticker set name
     */
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * A JSON-serialized object with information about the added sticker.
     * If exactly the same sticker had already been added to the set, then the set isn't changed.
     */
    @NotNull
    @JsonProperty("sticker")
    private final InputSticker sticker;

    @Override
    public BotMethod getMethod() {
        return BotMethod.ADD_STICKER_TO_SET;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Optional.of(sticker)
                .map(InputSticker::getSticker)
                .map(List::of)
                .orElse(List.of());
    }
}
