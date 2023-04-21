package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;

import java.util.List;

/**
 * Interface for methods with media payload that return Array response.
 */
public interface ListBotMediaMethodDefinition<RESPONSE extends BotApiResponse>
        extends BaseBotMediaMethodDefinition<List<RESPONSE>> {
}
