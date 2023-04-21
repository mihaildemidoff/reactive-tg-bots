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
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletestickerfromset">deleteStickerFromSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteStickerFromSetMethod implements BooleanBotMethodDefinition {

    /**
     * File identifier of the sticker
     */
    @NotNull
    @JsonProperty("sticker")
    private final String sticker;


    @Override
    public BotMethod getMethod() {
        return BotMethod.DELETE_STICKER_FROM_SET;
    }
}
