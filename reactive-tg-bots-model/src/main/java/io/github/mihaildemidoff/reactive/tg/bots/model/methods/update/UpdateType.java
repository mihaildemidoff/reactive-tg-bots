package io.github.mihaildemidoff.reactive.tg.bots.model.methods.update;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Allowed update type. Determines which entities will be returned with update
 */
@RequiredArgsConstructor
public enum UpdateType {

    /**
     * message
     */
    MESSAGE("message"),

    /**
     * edited_message
     */
    EDITED_MESSAGE("edited_message"),

    /**
     * channel_post
     */
    CHANNEL_POST("channel_post"),

    /**
     * edited_channel_post
     */
    EDITED_CHANNEL_POST("edited_channel_post"),

    /**
     * inline_query
     */
    INLINE_QUERY("inline_query"),

    /**
     * chosen_inline_result
     */
    CHOSEN_INLINE_RESULT("chosen_inline_result"),

    /**
     * callback_query
     */
    CALLBACK_QUERY("callback_query"),

    /**
     * shipping_query
     */
    SHIPPING_QUERY("shipping_query"),

    /**
     * pre_checkout_query
     */
    PRE_CHECKOUT_QUERY("pre_checkout_query"),

    /**
     * poll
     */
    POLL("poll"),

    /**
     * poll_answer
     */
    POLL_ANSWER("poll_answer"),

    /**
     * my_chat_member
     */
    MY_CHAT_MEMBER("my_chat_member"),

    /**
     * chat_member
     */
    CHAT_MEMBER("chat_member"),

    /**
     * chat_join_request
     */
    CHAT_JOIN_REQUEST("chat_join_request");

    /**
     * String value of enum
     */
    private final String value;

    /**
     * Returns string representation of enum.
     *
     * @return string value of enum
     */
    @JsonValue
    public String toValue() {
        return value;
    }

}
