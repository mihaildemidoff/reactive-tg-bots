package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.set;


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

/**
 * Use this method to set the title of a created sticker set. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickersettitle">setStickerSetTitle</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStickerSetTitleMethod implements BooleanBotMethodDefinition {

    /**
     * Sticker set name
     */
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


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_STICKER_SET_TITLE;
    }
}
