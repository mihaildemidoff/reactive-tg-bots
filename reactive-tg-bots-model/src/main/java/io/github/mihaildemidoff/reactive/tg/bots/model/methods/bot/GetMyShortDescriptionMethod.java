package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.BotShortDescription;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.LanguageCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get the current bot short description for the given user language.
 * Returns {@link io.github.mihaildemidoff.reactive.tg.bots.model.bot.BotShortDescription} on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmyshortdescription">getMyShortDescription</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMyShortDescriptionMethod implements TypedBotMethodDefinition<BotShortDescription> {

    /**
     * A two-letter ISO 639-1 language code or an empty string
     */
    @JsonProperty("language_code")
    private final LanguageCode languageCode;

    @Override
    public TypeReference<GenericBotApiResponse<BotShortDescription>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_MY_SHORT_DESCRIPTION;
    }
}
