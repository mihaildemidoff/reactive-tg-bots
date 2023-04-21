package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.forum;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.ListBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.Sticker;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to get custom emoji stickers, which can be used as a forum topic icon by any user.
 * Requires no parameters.
 * Returns an Array of {@link io.github.mihaildemidoff.reactive.tg.bots.model.sticker.Sticker} objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getforumtopiciconstickers">getForumTopicIconStickers</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetForumTopicIconStickersMethod implements ListBotMethodDefinition<Sticker> {

    @Override
    public TypeReference<GenericBotApiResponse<List<Sticker>>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_FORUM_TOPIC_ICON_STICKERS;
    }
}
