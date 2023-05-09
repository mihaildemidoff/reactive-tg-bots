package io.github.mihaildemidoff.reactive.tg.bots.autoconfiguration;

import io.github.mihaildemidoff.reactive.tg.bots.autoconfiguration.properties.TelegramProperties;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.DefaultTelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.DefaultTelegramPoller;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramPoller;
import io.github.mihaildemidoff.reactive.tg.bots.core.http.HttpClientBuilder;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.NoOpValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.ValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.ValidatorValidationService;
import jakarta.validation.Validator;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;


@AutoConfiguration(after = ValidationAutoConfiguration.class)
@ConditionalOnClass(TelegramClient.class)
@EnableConfigurationProperties(TelegramProperties.class)
public class ReactiveTgBotsAutoconfiguration {

    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient(final TelegramProperties telegramProperties) {
        return HttpClientBuilder.defaultHttpClient(telegramProperties.getBaseUrl(), telegramProperties.getTimeout());
    }

    @Bean
    @ConditionalOnMissingBean(TelegramClient.class)
    public TelegramClient telegramClient(final TelegramProperties properties,
                                         final HttpClient httpClient,
                                         final ValidationService validationService) {
        return new DefaultTelegramClient(properties, httpClient, validationService);
    }

    @Bean
    @ConditionalOnMissingBean(TelegramPoller.class)
    public TelegramPoller telegramPoller(final TelegramClient telegramClient,
                                         final TelegramProperties properties) {
        return new DefaultTelegramPoller(telegramClient, properties);
    }

    @Bean
    @ConditionalOnMissingBean(ValidationService.class)
    @ConditionalOnBean(Validator.class)
    @ConditionalOnProperty(name = "telegram.bot.validation.enabled", havingValue = "true", matchIfMissing = true)
    public ValidationService validatorValidationService(final Validator validator) {
        return new ValidatorValidationService(validator);
    }


    @Bean
    @ConditionalOnMissingBean(ValidationService.class)
    @ConditionalOnProperty(name = "telegram.bot.validation.enabled", havingValue = "false", matchIfMissing = true)
    public ValidationService noOpvalidationService() {
        return new NoOpValidationService();
    }


}
