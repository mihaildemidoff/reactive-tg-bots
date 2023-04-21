package io.github.mihaildemidoff.reactive.tg.bots.model.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.UpdateType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.List;

/**
 * Describes the current status of a webhook.
 *
 * @see <a href="https://core.telegram.org/bots/api#webhookinfo">WebhookInfo</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookInfo implements BotApiResponse {

    /**
     * Webhook URL, may be empty if webhook is not set up
     */
    @NotNull
    @JsonProperty("url")
    private final String url;

    /**
     * True, if a custom certificate was provided for webhook certificate checks
     */
    @NotNull
    @JsonProperty("has_custom_certificate")
    private final Boolean hasCustomCertificate;

    /**
     * Number of updates awaiting delivery
     */
    @NotNull
    @JsonProperty("pending_update_count")
    private final Long pendingUpdateCount;

    /**
     * <b>Optional.</b><br>
     * Currently used webhook IP address
     */
    @JsonProperty("ip_address")
    private final String ipAddress;

    /**
     * <b>Optional.</b><br>
     * Unix time for the most recent error that happened when trying to deliver an update via webhook
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("last_error_date")
    private final Instant lastErrorDate;

    /**
     * <b>Optional.</b><br>
     * Error message in human-readable format for the most recent error that happened when trying to deliver
     * an update via webhook
     */
    @JsonProperty("last_error_message")
    private final String lastErrorMessage;

    /**
     * <b>Optional.</b><br>
     * Unix time of the most recent error that happened when trying to synchronize available updates with
     * Telegram datacenters
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("last_synchronization_error_date")
    private final Instant lastSynchronizationDate;

    /**
     * <b>Optional.</b><br>
     * The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
     */
    @JsonProperty("max_connections")
    private final Long maxConnection;

    /**
     * <b>Optional.</b><br>
     * A list of update types the bot is subscribed to. Defaults to all update types except chat_member
     */
    @Valid
    @JsonProperty("allowed_updates")
    private final List<UpdateType> allowedUpdates;

}
