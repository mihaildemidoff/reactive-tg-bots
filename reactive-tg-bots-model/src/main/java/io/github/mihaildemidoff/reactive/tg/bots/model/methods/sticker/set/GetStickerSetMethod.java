package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.StickerSet;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#getstickerset">getStickerSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStickerSetMethod implements TypedBotMethodDefinition<StickerSet> {

    /**
     * Name of the sticker set
     */
    @NotNull
    @JsonProperty("name")
    private final String name;

    @Override
    public TypeReference<GenericBotApiResponse<StickerSet>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_STICKER_SET;
    }
}
