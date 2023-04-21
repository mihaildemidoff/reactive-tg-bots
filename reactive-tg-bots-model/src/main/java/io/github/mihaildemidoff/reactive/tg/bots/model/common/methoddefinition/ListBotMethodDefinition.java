package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;

import java.util.List;

/**
 * Interface for methods that return Array response.
 */
public interface ListBotMethodDefinition<RESPONSE extends BotApiResponse>
        extends BaseBotMethodDefinition<List<RESPONSE>> {
}
