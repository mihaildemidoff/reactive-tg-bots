package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.ListBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.Sticker;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to get information about custom emoji stickers by their identifiers.
 * Returns an Array of {@link io.github.mihaildemidoff.reactive.tg.bots.model.sticker.Sticker} objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getcustomemojistickers">getCustomEmojiStickers</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCustomEmojiStickersMethod implements ListBotMethodDefinition<Sticker> {

    /**
     * List of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
     */
    // TODO: add emoji validation
    @Size(max = 200)
    @NotNull
    @JsonProperty("custom_emoji_ids")
    private final List<String> customEmojiIds;

    @Override
    public TypeReference<GenericBotApiResponse<List<Sticker>>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_CUSTOM_EMOJI_STICKERS;
    }
}
