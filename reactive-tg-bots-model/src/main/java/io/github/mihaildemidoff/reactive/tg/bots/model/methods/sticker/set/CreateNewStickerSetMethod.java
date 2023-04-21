package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.InputSticker;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.StickerFormat;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.StickerType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus
 * created. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#createnewstickerset">createNewStickerSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateNewStickerSetMethod implements BooleanBotMediaMethodDefinition {

    /**
     * User identifier of created sticker set owner
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals).
     * Can contain only English letters, digits and underscores.
     * Must begin with a letter, can't contain consecutive underscores and must end in "_by_&lt;bot_username&gt;".
     * &lt;bot_username&gt; is case insensitive. 1-64 characters.
     */
    @Size(min = 1, max = 64)
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * Sticker set title, 1-64 characters
     */
    @Size(min = 1, max = 64)
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * A JSON-serialized list of 1-50 initial stickers to be added to the sticker set
     */
    @Valid
    @Size(min = 1, max = 50)
    @NotNull
    @JsonProperty("stickers")
    private final List<InputSticker> stickers;

    /**
     * Format of stickers in the set, must be one of “static”, “animated”, “video”
     */
    @NotNull
    @JsonProperty("sticker_format")
    private final StickerFormat stickerFormat;

    /**
     * Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”.
     * By default, a regular sticker set is created.
     */
    @JsonProperty("sticker_type")
    private final StickerType stickerType;

    /**
     * Pass True if stickers in the sticker set must be repainted to the color of text when used in messages,
     * the accent color if used as emoji status, white on chat photos, or another appropriate color based on context;
     * for custom emoji sticker sets only
     */
    @JsonProperty("needs_repainting")
    private final Boolean needsRepainting;


    @Override
    public BotMethod getMethod() {
        return BotMethod.CREATE_NEW_STICKER_SET;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Optional.ofNullable(stickers)
                .orElse(List.of())
                .stream()
                .map(InputSticker::getSticker)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
