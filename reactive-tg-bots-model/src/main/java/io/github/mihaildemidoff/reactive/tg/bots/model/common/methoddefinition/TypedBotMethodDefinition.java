package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;

/**
 * Interface for methods that return non-primitive and non-embedded classes.
 * Those types should be marked with {@link BotApiResponse}
 */
public interface TypedBotMethodDefinition<RESPONSE extends BotApiResponse> extends BaseBotMethodDefinition<RESPONSE> {
}
