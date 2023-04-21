package io.github.mihaildemidoff.reactive.tg.bots.model.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatJoinRequest;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatMemberUpdated;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.CallbackQuery;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.ChosenInlineResult;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.InlineQuery;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.payments.PreCheckoutQuery;
import io.github.mihaildemidoff.reactive.tg.bots.model.payments.ShippingQuery;
import io.github.mihaildemidoff.reactive.tg.bots.model.poll.Poll;
import io.github.mihaildemidoff.reactive.tg.bots.model.poll.PollAnswer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 *
 * @see <a href="https://core.telegram.org/bots/api#update">Update</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Update implements BotApiResponse {

    /**
     * The update's unique identifier. Update identifiers start from a certain positive number and increase
     * sequentially. This ID becomes especially handy if you're using webhooks, since it allows you to ignore repeated
     * updates or to restore the correct update sequence, should they get out of order. If there are no new updates for
     * at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
     */
    @NotNull
    @JsonProperty("update_id")
    private final Long updateId;

    /**
     * <b>Optional.</b><br>
     * New incoming message of any kind - text, photo, sticker, etc.
     */
    @Valid
    @JsonProperty("message")
    private final Message message;

    /**
     * <b>Optional.</b><br>
     * New version of a message that is known to the bot and was edited
     */
    @Valid
    @JsonProperty("edited_message")
    private final Message editedMessage;

    /**
     * <b>Optional.</b><br>
     * New incoming channel post of any kind - text, photo, sticker, etc.
     */
    @Valid
    @JsonProperty("channel_post")
    private final Message channelPost;

    /**
     * <b>Optional.</b><br>
     * New version of a channel post that is known to the bot and was edited
     */
    @Valid
    @JsonProperty("edited_channel_post")
    private final Message editedChannelPost;

    /**
     * <b>Optional.</b><br>
     * New incoming inline query
     */
    @Valid
    @JsonProperty("inline_query")
    private final InlineQuery inlineQuery;

    /**
     * <b>Optional.</b><br>
     * The result of an inline query that was chosen by a user and sent to their chat partner.
     * Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
     */
    @Valid
    @JsonProperty("chosen_inline_result")
    private final ChosenInlineResult chosenInlineResult;

    /**
     * <b>Optional.</b><br>
     * New incoming callback query
     */
    @Valid
    @JsonProperty("callback_query")
    private final CallbackQuery callbackQuery;

    /**
     * <b>Optional.</b><br>
     * New incoming shipping query. Only for invoices with flexible price
     */
    @Valid
    @JsonProperty("shipping_query")
    private final ShippingQuery shippingQuery;

    /**
     * <b>Optional.</b><br>
     * New incoming pre-checkout query. Contains full information about checkout
     */
    @Valid
    @JsonProperty("pre_checkout_query")
    private final PreCheckoutQuery preCheckoutQuery;

    /**
     * <b>Optional.</b><br>
     * New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
     */
    @Valid
    @JsonProperty("poll")
    private final Poll poll;

    /**
     * <b>Optional.</b><br>
     * A user changed their answer in a non-anonymous poll.
     * Bots receive new votes only in polls that were sent by the bot itself.
     */
    @Valid
    @JsonProperty("poll_answer")
    private final PollAnswer pollAnswer;

    /**
     * <b>Optional.</b><br>
     * The bot's chat member status was updated in a chat.
     * For private chats, this update is received only when the bot is blocked or unblocked by the user.
     */
    @Valid
    @JsonProperty("my_chat_member")
    private final ChatMemberUpdated myChatMember;

    /**
     * <b>Optional.</b><br>
     * A chat member's status was updated in a chat.
     * The bot must be an administrator in the chat and must explicitly specify “chat_member” in the list of
     * allowed_updates to receive these updates.
     */
    @Valid
    @JsonProperty("chat_member")
    private final ChatMemberUpdated chatMember;

    /**
     * <b>Optional.</b><br>
     * A request to join the chat has been sent.
     * The bot must have the can_invite_users administrator right in the chat to receive these updates.
     */
    @Valid
    @JsonProperty("chat_join_request")
    private final ChatJoinRequest chatJoinRequest;

}
