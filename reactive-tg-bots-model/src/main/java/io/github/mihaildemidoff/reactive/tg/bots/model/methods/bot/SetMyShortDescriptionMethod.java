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
 * Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together
 * with the link when users share the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmyshortdescription">setMyShortDescription</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMyShortDescriptionMethod implements BooleanBotMethodDefinition {

    /**
     * New short description for the bot; 0-120 characters.
     * Pass an empty string to remove the dedicated short description for the given language.
     */
    @Size(max = 120)
    @JsonProperty("short_description")
    private final String shortDescription;

    /**
     * A two-letter ISO 639-1 language code. If empty, the short description will be applied to all users for whose
     * language there is no dedicated short description.
     */
    @JsonProperty("language_code")
    private final LanguageCode languageCode;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_MY_SHORT_DESCRIPTION;
    }
}
