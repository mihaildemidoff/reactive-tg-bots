package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import jakarta.validation.constraints.NotNull;

/**
 * Interface-marker. All telegram methods should implement this class.
 *
 * @param <RESPONSE> response type, that telegram returns in the 'result' field
 */
public interface BaseBotMethodDefinition<RESPONSE> {

    /**
     * True if method could provide media payload, otherwise false
     *
     * @return true if method produces media payload
     */
    @JsonIgnore
    default boolean isMediaMethod() {
        return false;
    }

    /**
     * Response class used for response deserialization.
     *
     * @return TypeReference of response
     */
    @JsonIgnore
    @NotNull
    TypeReference<GenericBotApiResponse<RESPONSE>> getResponseClass();

    /**
     * Telegram bot method.
     *
     * @return bot method
     */
    @JsonIgnore
    @NotNull
    BotMethod getMethod();

}
