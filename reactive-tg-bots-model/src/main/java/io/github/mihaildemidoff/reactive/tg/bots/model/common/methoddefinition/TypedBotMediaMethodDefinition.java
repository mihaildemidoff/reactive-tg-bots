package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;

/**
 * Interface for methods with media payload that return non-primitive and non-embedded classes.
 * Those types should be marked with {@link BotApiResponse}
 */
public interface TypedBotMediaMethodDefinition<RESPONSE extends BotApiResponse> extends BaseBotMediaMethodDefinition<RESPONSE> {
}
