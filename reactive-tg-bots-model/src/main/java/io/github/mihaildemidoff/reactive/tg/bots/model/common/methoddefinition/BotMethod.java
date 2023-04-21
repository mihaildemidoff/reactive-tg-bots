package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Telegram bot method.
 */
@Getter
@RequiredArgsConstructor
public enum BotMethod {

    /**
     * @see <a href="https://core.telegram.org/bots/api#getme">getMe</a>
     */
    GET_ME("getMe"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getupdates">getUpdates</a>
     */
    GET_UPDATES("getUpdates"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getmycommands">getMyCommands</a>
     */
    GET_MY_COMMANDS("getMyCommands"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getmydescription">getMyDescription</a>
     */
    GET_MY_DESCRIPTION("getMyDescription"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getmyshortdescription">getMyShortDescription</a>
     */
    GET_MY_SHORT_DESCRIPTION("getMyShortDescription"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getmyname">getMyName</a>
     */
    GET_MY_NAME("getMyName"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#logout">logOut</a>
     */
    LOG_OUT("logOut"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#close">close</a>
     */
    CLOSE("close"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setmycommands">setMyCommands</a>
     */
    SET_MY_COMMANDS("setMyCommands"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletemycommands">deleteMyCommands</a>
     */
    DELETE_MY_COMMANDS("deleteMyCommands"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendmessage">sendMessage</a>
     */
    SEND_MESSAGE("sendMessage"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setmyname">setMyName</a>
     */
    SET_MY_NAME("setMyName"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setmydescription">setMyDescription</a>
     */
    SET_MY_DESCRIPTION("setMyDescription"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setmyshortdescription">setMyShortDescription</a>
     */
    SET_MY_SHORT_DESCRIPTION("setMyShortDescription"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getmydefaultadministratorrights">getMyDefaultAdministratorRights</a>
     */
    GET_MY_DEFAULT_ADMINISTRATOR_RIGHTS("getMyDefaultAdministratorRights"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setmydefaultadministratorrights">setMyDefaultAdministratorRights</a>
     */
    SET_MY_DEFAULT_ADMINISTRATOR_RIGHTS("setMyDefaultAdministratorRights"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setchatmenubutton">setChatMenuButton</a>
     */
    SET_CHAT_MENU_BUTTON("setChatMenuButton"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getchatmenubutton">getChatMenuButton</a>
     */
    GET_CHAT_MENU_BUTTON("getChatMenuButton"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">answerCallbackQuery</a>
     */
    ANSWER_CALLBACK_QUERY("answerCallbackQuery"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletewebhook">deleteWebhook</a>
     */
    DELETE_WEBHOOK("deleteWebhook"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getwebhookinfo">getWebhookInfo</a>
     */
    GET_WEBHOOK_INFO("getWebhookInfo"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setwebhook">setWebhook</a>
     */
    SET_WEBHOOK("setWebhook"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletemessage">deleteMessage</a>
     */
    DELETE_MESSAGE("deleteMessage"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getuserprofilephotos">getUserProfilePhotos</a>
     */
    GET_USER_PROFILE_PHOTOS("getUserProfilePhotos"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setpassportdataerrors">setPassportDataErrors</a>
     */
    SET_PASSPORT_DATA_ERRORS("setPassportDataErrors"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#answerinlinequery">answerInlineQuery</a>
     */
    ANSWER_INLINE_QUERY("answerInlineQuery"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#answerwebappquery">answerWebAppQuery</a>
     */
    ANSWER_WEB_APP_QUERY("answerWebAppQuery"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getfile">getFile</a>
     */
    GET_FILE("getFile"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getgamehighscores">getGameHighScores</a>
     */
    GET_GAME_HIGH_SCORES("getGameHighScores"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendgame">sendGame</a>
     */
    SEND_GAME("sendGame"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setgamescore">setGameScore</a>
     */
    SET_GAME_SCORE("setGameScore"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#banchatmember">banChatMember</a>
     */
    BAN_CHAT_MEMBER("banChatMember"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#banchatsenderchat">banChatSenderChat</a>
     */
    BAN_CHAT_SENDER_CHAT("banChatSenderChat"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unbanchatmember">unbanChatMember</a>
     */
    UNBAN_CHAT_MEMBER("unbanChatMember"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unbanchatsenderchat">unbanChatSenderChat</a>
     */
    UNBAN_CHAT_SENDER_CHAT("unbanChatSenderChat"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getchat">getChat</a>
     */
    GET_CHAT("getChat"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#leavechat">leaveChat</a>
     */
    LEAVE_CHAT("leaveChat"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendchataction">sendChatAction</a>
     */
    SEND_CHAT_ACTION("sendChatAction"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#closeforumtopic">closeForumTopic</a>
     */
    CLOSE_FORUM_TOPIC("closeForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">closeGeneralForumTopic</a>
     */
    CLOSE_GENERAL_FORUM_TOPIC("closeGeneralForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#createforumtopic">createForumTopic</a>
     */
    CREATE_FORUM_TOPIC("createForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deleteforumtopic">deleteForumTopic</a>
     */
    DELETE_FORUM_TOPIC("deleteForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editforumtopic">editForumTopic</a>
     */
    EDIT_FORUM_TOPIC("editForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">editGeneralForumTopic</a>
     */
    EDIT_GENERAL_FORUM_TOPIC("editGeneralForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getforumtopiciconstickers">getForumTopicIconStickers</a>
     */
    GET_FORUM_TOPIC_ICON_STICKERS("getForumTopicIconStickers"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#hidegeneralforumtopic">hideGeneralForumTopic</a>
     */
    HIDE_GENERAL_FORUM_TOPIC("hideGeneralForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#reopenforumtopic">reopenForumTopic</a>
     */
    REOPEN_FORUM_TOPIC("reopenForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#reopengeneralforumtopic">reopenGeneralForumTopic</a>
     */
    REOPEN_GENERAL_FORUM_TOPIC("reopenGeneralForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unhidegeneralforumtopic">unhideGeneralForumTopic</a>
     */
    UNHIDE_GENERAL_FORUM_TOPIC("unhideGeneralForumTopic"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">unpinAllForumTopicMessages</a>
     */
    UNPIN_ALL_FORUM_TOPIC_MESSAGES("unpinAllForumTopicMessages"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#createchatinvitelink">createChatInviteLink</a>
     */
    CREATE_CHAT_INVITE_LINK("createChatInviteLink"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editchatinvitelink">editChatInviteLink</a>
     */
    EDIT_CHAT_INVITE_LINK("editChatInviteLink"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#exportchatinvitelink">exportChatInviteLink</a>
     */
    EXPORT_CHAT_INVITE_LINK("exportChatInviteLink"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#revokechatinvitelink">revokeChatInviteLink</a>
     */
    REVOKE_CHAT_INVITE_LINK("revokeChatInviteLink"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendphoto">sendPhoto</a>
     */
    SEND_PHOTO("sendPhoto"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendpoll">sendPoll</a>
     */
    SEND_POLL("sendPoll"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">answerPreCheckoutQuery</a>
     */
    ANSWER_PRE_CHECKOUT_QUERY("answerPreCheckoutQuery"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#answershippingquery">answerShippingQuery</a>
     */
    ANSWER_SHIPPING_QUERY("answerShippingQuery"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#createinvoicelink">createInvoiceLink</a>
     */
    CREATE_INVOICE_LINK("createInvoiceLink"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendinvoice">sendInvoice</a>
     */
    SEND_INVOICE("sendInvoice"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#approvechatjoinrequest">approveChatJoinRequest</a>
     */
    APPROVE_CHAT_JOIN_REQUEST("approveChatJoinRequest"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">declineChatJoinRequest</a>
     */
    DECLINE_CHAT_JOIN_REQUEST("declineChatJoinRequest"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletechatstickerset">deleteChatStickerSet</a>
     */
    DELETE_CHAT_STICKER_SET("deleteChatStickerSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">setChatAdministratorCustomTitle</a>
     */
    SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE("setChatAdministratorCustomTitle"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setchatdescription">setChatDescription</a>
     */
    SET_CHAT_DESCRIPTION("setChatDescription"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setchatpermissions">setChatPermissions</a>
     */
    SET_CHAT_PERMISSIONS("setChatPermissions"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setchattitle">setChatTitle</a>
     */
    SET_CHAT_TITLE("setChatTitle"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unpinallchatmessages">setChatStickerSet</a>
     */
    SET_CHAT_STICKER_SET("setChatStickerSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getchatadministrators">getChatAdministrators</a>
     */
    GET_CHAT_ADMINISTRATORS("getChatAdministrators"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getchatmembercount">getChatMemberCount</a>
     */
    GET_CHAT_MEMBER_COUNT("getChatMemberCount"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getchatmember">getChatMember</a>
     */
    GET_CHAT_MEMBER("getChatMember"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#promotechatmember">promoteChatMember</a>
     */
    PROMOTE_CHAT_MEMBER("promoteChatMember"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#restrictchatmember">restrictChatMember</a>
     */
    RESTRICT_CHAT_MEMBER("restrictChatMember"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#pinchatmessage">pinChatMessage</a>
     */
    PIN_CHAT_MESSAGE("pinChatMessage"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unpinallchatmessages">unpinAllChatMessages</a>
     */
    UNPIN_ALL_CHAT_MESSAGES("unpinAllChatMessages"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#unpinchatmessage">unpinChatMessage</a>
     */
    UNPIN_CHAT_MESSAGE("unpinChatMessage"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getcustomemojistickers">getCustomEmojiStickers</a>
     */
    GET_CUSTOM_EMOJI_STICKERS("getCustomEmojiStickers"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#stoppoll">stopPoll</a>
     */
    STOP_POLL("stopPoll"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#copymessage">copyMessage</a>
     */
    COPY_MESSAGE("copyMessage"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#forwardmessage">forwardMessage</a>
     */
    FORWARD_MESSAGE("forwardMessage"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#senddice">sendDice</a>
     */
    SEND_DICE("sendDice"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendcontact">sendContact</a>
     */
    SEND_CONTACT("sendContact"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendlocation">sendLocation</a>
     */
    SEND_LOCATION("sendLocation"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendvenue">sendVenue</a>
     */
    SEND_VENUE("sendVenue"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setstickeremojilist">setStickerEmojiList</a>
     */
    SET_STICKER_EMOJI_LIST("setStickerEmojiList"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setstickerkeywords">setStickerKeywords</a>
     */
    SET_STICKER_KEYWORDS("setStickerKeywords"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setstickermaskposition">setStickerMaskPosition</a>
     */
    SET_STICKER_MASK_POSITION("setStickerMaskPosition"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletechatphoto">deleteChatPhoto</a>
     */
    DELETE_CHAT_PHOTO("deleteChatPhoto"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#getstickerset">getStickerSet</a>
     */
    GET_STICKER_SET("getStickerSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletestickerfromset">deleteStickerFromSet</a>
     */
    DELETE_STICKER_FROM_SET("deleteStickerFromSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#deletestickerset">deleteStickerSet</a>
     */
    DELETE_STICKER_SET("deleteStickerSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">
     * setCustomEmojiStickerSetThumbnail</a>
     */
    SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL("setCustomEmojiStickerSetThumbnail"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setstickerpositioninset">setStickerPositionInSet</a>
     */
    SET_STICKER_POSITION_IN_SET("setStickerPositionInSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setstickersettitle">setStickerSetTitle</a>
     */
    SET_STICKER_SET_TITLE("setStickerSetTitle"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendvoice">sendVoice</a>
     */
    SEND_VOICE("sendVoice"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendaudio">sendAudio</a>
     */
    SEND_AUDIO("sendAudio"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#senddocument">sendDocument</a>
     */
    SEND_DOCUMENT("sendDocument"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendanimation">sendAnimation</a>
     */
    SEND_ANIMATION("sendAnimation"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendvideo">sendVideo</a>
     */
    SEND_VIDEO("sendVideo"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendvideonote">sendVideoNote</a>
     */
    SEND_VIDEO_NOTE("sendVideoNote"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#uploadstickerfile">uploadStickerFile</a>
     */
    UPLOAD_STICKER_FILE("uploadStickerFile"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendsticker">sendSticker</a>
     */
    SEND_STICKER("sendSticker"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">setStickerSetThumbnail</a>
     */
    SET_STICKER_SET_THUMBNAIL("setStickerSetThumbnail"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editmessagecaption">editMessageCaption</a>
     */
    EDIT_MESSAGE_CAPTION("editMessageCaption"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editmessagelivelocation">editMessageLiveLocation</a>
     */
    EDIT_MESSAGE_LIVE_LOCATION("editMessageLiveLocation"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editmessagemedia">editMessageMedia</a>
     */
    EDIT_MESSAGE_MEDIA("editMessageMedia"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">editMessageReplyMarkup</a>
     */
    EDIT_MESSAGE_REPLY_MARKUP("editMessageReplyMarkup"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#editmessagetext">editMessageText</a>
     */
    EDIT_MESSAGE_TEXT("editMessageText"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">stopMessageLiveLocation</a>
     */
    STOP_MESSAGE_LIVE_LOCATION("stopMessageLiveLocation"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#sendmediagroup">sendMediaGroup</a>
     */
    SEND_MEDIA_GROUP("sendMediaGroup"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#setchatphoto">setChatPhoto</a>
     */
    SET_CHAT_PHOTO("setChatPhoto"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#addstickertoset">addStickerToSet</a>
     */
    ADD_STICKER_TO_SET("addStickerToSet"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#createnewstickerset">createNewStickerSet</a>
     */
    CREATE_NEW_STICKER_SET("createNewStickerSet");

    /**
     * Method name, used as path param during request
     */
    private final String methodName;

    /**
     * Get method name.
     *
     * @return method name
     */
    @JsonValue
    public String toMethodName() {
        return methodName;
    }

}
