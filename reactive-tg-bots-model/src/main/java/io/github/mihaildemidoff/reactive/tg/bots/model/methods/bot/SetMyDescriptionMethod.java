package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.LanguageCode;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmydescription">setMyDescription</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMyDescriptionMethod implements BooleanBotMethodDefinition {

    /**
     * New bot description; 0-512 characters.
     * Pass an empty string to remove the dedicated description for the given language.
     */
    @Size(max = 512)
    @JsonProperty("description")
    private final String description;

    /**
     * A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language
     * there is no dedicated description.
     */
    @JsonProperty("language_code")
    private final LanguageCode languageCode;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_MY_DESCRIPTION;
    }
}
