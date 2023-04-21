package io.github.mihaildemidoff.reactive.tg.bots.model.methods.webhook;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.UpdateType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update
 * for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized Update.
 * In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns True on success.
 * <p>
 * If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter
 * secret_token. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret
 * token as content.
 *
 * <b>Notes</b>
 * <ol>
 * <li>You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.</li>
 * <li>To use a self-signed certificate, you need to upload your public key certificate using certificate parameter.
 * Please upload as InputFile, sending a String will not work.</li>
 * <li>Ports currently supported for webhooks: 443, 80, 88, 8443.</li>
 * </ol>
 *
 * @see <a href="https://core.telegram.org/bots/api#setwebhook">setWebhook</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetWebhookMethod implements BooleanBotMediaMethodDefinition {

    /**
     * HTTPS URL to send updates to. Use an empty string to remove webhook integration
     */
    @NotNull
    @JsonProperty("url")
    private final String url;

    /**
     * Upload your public key certificate so that the root certificate in use can be checked.
     * See our self-signed guide for details.
     */
    @JsonProperty("certificate")
    private final InputFile certificate;

    /**
     * The fixed IP address which will be used to send webhook requests instead of the IP address resolved through DNS
     */
    @JsonProperty("ip_address")
    private final String ipAddress;

    /**
     * The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100.
     * Defaults to 40. Use lower values to limit the load on your bot's server, and higher values to increase your
     * bot's throughput.
     */
    @Max(100)
    @Min(1)
    @JsonProperty("max_connections")
    private final Long maxConnection;

    /**
     * A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”,
     * “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list
     * of available update types. Specify an empty list to receive all update types except chat_member (default).
     * If not specified, the previous setting will be used.
     * Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted
     * updates may be received for a short period of time.
     */
    @Valid
    @JsonProperty("allowed_updates")
    private final List<UpdateType> allowedUpdates;

    /**
     * Pass True to drop all pending updates
     */
    @JsonProperty("drop_pending_updates")
    private final Boolean dropPendingUpdates;

    /**
     * A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request,
     * 1-256 characters. Only characters A-Z, a-z, 0-9, _ and - are allowed. The header is useful to ensure that the
     * request comes from a webhook set by you.
     */
    @Pattern(regexp = "[A-Za-z0-9_\\-]{1,256}")
    @Size(min = 1, max = 256)
    @JsonProperty("secret_token")
    private final String secretToken;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_WEBHOOK;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Stream.ofNullable(certificate)
                .collect(Collectors.toList());
    }
}
