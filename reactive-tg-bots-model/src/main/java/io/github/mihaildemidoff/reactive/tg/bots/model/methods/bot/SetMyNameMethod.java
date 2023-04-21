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
 * Use this method to change the bot's name. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmyname">setMyName</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMyNameMethod implements BooleanBotMethodDefinition {

    /**
     * New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language.
     * Name should be not empty if you doesn't provide language code
     */
    @Size(max = 64)
    @JsonProperty("name")
    private final String name;

    /**
     * A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose language there is
     * no dedicated name.
     */
    @JsonProperty("language_code")
    private final LanguageCode languageCode;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_MY_NAME;
    }
}
