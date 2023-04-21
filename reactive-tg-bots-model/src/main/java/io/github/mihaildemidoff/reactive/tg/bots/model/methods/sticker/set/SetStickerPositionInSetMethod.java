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
 * Use this method to move a sticker in a set created by the bot to a specific position. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickerpositioninset">setStickerPositionInSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStickerPositionInSetMethod implements BooleanBotMethodDefinition {

    /**
     * File identifier of the sticker
     */
    @NotNull
    @JsonProperty("sticker")
    private final String sticker;

    /**
     * New sticker position in the set, zero-based
     */
    @NotNull
    @JsonProperty("position")
    private final Long position;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_STICKER_POSITION_IN_SET;
    }
}
