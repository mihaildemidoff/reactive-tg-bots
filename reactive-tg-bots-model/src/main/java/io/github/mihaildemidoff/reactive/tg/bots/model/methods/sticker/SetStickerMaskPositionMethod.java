package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.MaskPosition;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to change the mask position of a mask sticker.
 * The sticker must belong to a sticker set that was created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickermaskposition">setStickerMaskPosition</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStickerMaskPositionMethod implements BooleanBotMethodDefinition {

    /**
     * File identifier of the sticker
     */
    @NotNull
    @JsonProperty("sticker")
    private final String sticker;

    /**
     * A JSON-serialized object with the position where the mask should be placed on faces.
     * Omit the parameter to remove the mask position.
     */
    @Valid
    @NotNull
    @JsonProperty("mask_position")
    private final MaskPosition maskPosition;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_STICKER_MASK_POSITION;
    }
}
