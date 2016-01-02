/*
 * The MIT License
 *
 * Copyright 2016 xxlabaza.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ru.xxlabaza.telegram.api;

import feign.Param;
import feign.RequestLine;
import java.math.BigDecimal;
import java.util.List;
import ru.xxlabaza.telegram.api.type.ForceReply;
import ru.xxlabaza.telegram.api.type.Message;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardHide;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardMarkup;
import ru.xxlabaza.telegram.api.type.Update;
import ru.xxlabaza.telegram.api.type.User;

/**
 *
 * @author Artem Labazin
 *
 * @since Jun 30, 2015 | 9:57:35 PM
 *
 * @version 1.0.0
 */
interface TelegramApi {

    /**
     * A simple method for testing your bot's auth token. Requires no parameters.
     *
     * @return Returns basic information about the bot in form of a {@link User} object.
     */
    @RequestLine("GET /getMe")
    Response<User> getMe ();

    /**
     * Use this method to send text messages.
     *
     * @param chat           - Unique identifier for the target chat or username of the target channel
     *                       (in the format @channelusername)
     * @param text           - Text of the message to be sent
     * @param mode           - Send Markdown, if you want Telegram apps to show bold, italic and inline URLs in your
     *                       bot's message
     * @param disablePreview - Disables link previews for links in this message
     * @param replyTo        - If the message is a reply, ID of the original message
     * @param reply          - Additional interface options. A JSON-serialized object for a custom reply keyboard
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendMessage?" +
                 "chat_id={chat}&" +
                 "text={text}&" +
                 "parse_mode={mode}&" +
                 "disable_web_page_preview={disablePreview}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendMessage (@Param("chat") String chat,
                                   @Param("text") String text,
                                   @Param("mode") String mode,
                                   @Param("disablePreview") boolean disablePreview,
                                   @Param("replyTo") Integer replyTo,
                                   @Param("reply") ReplyKeyboardMarkup reply);

    /**
     * Use this method to send text messages.
     *
     * @param chat           - Unique identifier for the target chat or username of the target channel
     *                       (in the format @channelusername)
     * @param text           - Text of the message to be sent
     * @param mode           - Send Markdown, if you want Telegram apps to show bold, italic and inline URLs in your
     *                       bot's message
     * @param disablePreview - Disables link previews for links in this message
     * @param replyTo        - If the message is a reply, ID of the original message
     * @param reply          - Additional interface options. A JSON-serialized object for a instructions to hide
     *                       keyboard
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendMessage?" +
                 "chat_id={chat}&" +
                 "text={text}&" +
                 "parse_mode={mode}&" +
                 "disable_web_page_preview={disablePreview}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendMessage (@Param("chat") String chat,
                                   @Param("text") String text,
                                   @Param("mode") String mode,
                                   @Param("disablePreview") boolean disablePreview,
                                   @Param("replyTo") Integer replyTo,
                                   @Param("reply") ReplyKeyboardHide reply);

    /**
     * Use this method to send text messages.
     *
     * @param chat           - Unique identifier for the target chat or username of the target channel
     *                       (in the format @channelusername)
     * @param text           - Text of the message to be sent
     * @param mode           - Send Markdown, if you want Telegram apps to show bold, italic and inline URLs in your
     *                       bot's message
     * @param disablePreview - Disables link previews for links in this message
     * @param replyTo        - If the message is a reply, ID of the original message
     * @param reply          - Additional interface options. A JSON-serialized object to force a reply from the user
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendMessage?" +
                 "chat_id={chat}&" +
                 "text={text}&" +
                 "parse_mode={mode}&" +
                 "disable_web_page_preview={disablePreview}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendMessage (@Param("chat") String chat,
                                   @Param("text") String text,
                                   @Param("mode") String mode,
                                   @Param("disablePreview") boolean disablePreview,
                                   @Param("replyTo") Integer replyTo,
                                   @Param("reply") ForceReply reply);

    /**
     * Use this method to forward messages of any kind.
     *
     * @param chat     - Unique identifier for the target chat or username of the target channel
     *                 (in the format @channelusername)
     * @param fromChat - Unique identifier for the chat where the original message was sent
     *                 (or channel username in the format @channelusername)
     * @param message  - Unique message identifier
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /forwardMessage?" +
                 "chat_id={chat}&" +
                 "from_chat_id={fromChat}&" +
                 "message_id={message}")
    Response<Message> forwardMessage (@Param("chat") String chat,
                                      @Param("fromChat") String fromChat,
                                      @Param("message") Integer message);

    /**
     * Use this method to send .webp stickers.
     *
     * @param chat    - Unique identifier for the target chat or username of the target channel
     *                (in the format @channelusername)
     * @param sticker - Sticker to send. You can pass a file_id as String to resend a sticker that is already on
     *                the Telegram servers.
     * @param replyTo - If the message is a reply, ID of the original message
     * @param reply   - Additional interface options. A JSON-serialized object for a custom reply keyboard
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendSticker?" +
                 "chat_id={chat}&" +
                 "sticker={sticker}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendSticker (@Param("chat") String chat,
                                   @Param("sticker") String sticker,
                                   @Param("replyTo") Integer replyTo,
                                   @Param("reply") ReplyKeyboardMarkup reply);

    /**
     * Use this method to send .webp stickers.
     *
     * @param chat    - Unique identifier for the target chat or username of the target channel
     *                (in the format @channelusername)
     * @param sticker - Sticker to send. You can pass a file_id as String to resend a sticker that is already on
     *                the Telegram servers.
     * @param replyTo - If the message is a reply, ID of the original message
     * @param reply   - Additional interface options. A JSON-serialized object for a instructions to hide keyboard
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendSticker?" +
                 "chat_id={chat}&" +
                 "sticker={sticker}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendSticker (@Param("chat") String chat,
                                   @Param("sticker") String sticker,
                                   @Param("replyTo") Integer replyTo,
                                   @Param("reply") ReplyKeyboardHide reply);

    /**
     * Use this method to send .webp stickers.
     *
     * @param chat    - Unique identifier for the target chat or username of the target channel
     *                (in the format @channelusername)
     * @param sticker - Sticker to send. You can pass a file_id as String to resend a sticker that is already on
     *                the Telegram servers.
     * @param replyTo - If the message is a reply, ID of the original message
     * @param reply   - Additional interface options. A JSON-serialized object to force a reply from the user
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendSticker?" +
                 "chat_id={chat}&" +
                 "sticker={sticker}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendSticker (@Param("chat") String chat,
                                   @Param("sticker") String sticker,
                                   @Param("replyTo") Integer replyTo,
                                   @Param("reply") ForceReply reply);

    /**
     * *
     * Use this method to send point on the map.
     *
     * @param chat      - Unique identifier for the message recipient — User or GroupChat id
     * @param latitude  - Latitude of location
     * @param longitude - Longitude of location
     * @param replyTo   - If the message is a reply, ID of the original message
     * @param reply     - Additional interface options. A JSON-serialized object for a custom reply keyboard
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendLocation?" +
                 "chat_id={chat}&" +
                 "latitude={latitude}&" +
                 "longitude={longitude}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendLocation (@Param("chat") String chat,
                                    @Param("latitude") BigDecimal latitude,
                                    @Param("longitude") BigDecimal longitude,
                                    @Param("replyTo") Integer replyTo,
                                    @Param("reply") ReplyKeyboardMarkup reply);

    /**
     * Use this method to send point on the map
     *
     * @param chat      - Unique identifier for the message recipient — User or GroupChat id
     * @param latitude  - Latitude of location
     * @param longitude - Longitude of location
     * @param replyTo   - If the message is a reply, ID of the original message
     * @param reply     - Additional interface options. A JSON-serialized object for the instructions to hide keyboard
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendLocation?" +
                 "chat_id={chat}&" +
                 "latitude={latitude}&" +
                 "longitude={longitude}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendLocation (@Param("chat") String chat,
                                    @Param("latitude") BigDecimal latitude,
                                    @Param("longitude") BigDecimal longitude,
                                    @Param("replyTo") Integer replyTo,
                                    @Param("reply") ReplyKeyboardHide reply);

    /**
     * Use this method to send point on the map.
     *
     * @param chat      - Unique identifier for the message recipient — User or GroupChat id
     * @param latitude  - Latitude of location
     * @param longitude - Longitude of location
     * @param replyTo   - If the message is a reply, ID of the original message
     * @param reply     - Additional interface options. A JSON-serialized object for to force a reply from the user.
     *
     * @return On success, the sent {@link Message} is returned.
     */
    @RequestLine("POST /sendLocation?" +
                 "chat_id={chat}&" +
                 "latitude={latitude}&" +
                 "longitude={longitude}&" +
                 "reply_to_message_id={replyTo}&" +
                 "reply_markup={reply}")
    Response<Message> sendLocation (@Param("chat") String chat,
                                    @Param("latitude") BigDecimal latitude,
                                    @Param("longitude") BigDecimal longitude,
                                    @Param("replyTo") Integer replyTo,
                                    @Param("reply") ForceReply reply);

    /**
     * Use this method when you need to tell the user that something is happening on the bot's side. The status is set
     * for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * <p>
     * Example: The ImageBot needs some time to process a request and upload the image. Instead of sending a text
     * message along the lines of “Retrieving image, please wait…”, the bot may use sendChatAction with action =
     * upload_photo. The user will see a “sending photo” status for the bot.
     * <p>
     * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
     *
     * @param chat   - Unique identifier for the target chat or username of the target channel
     *               (in the format @channelusername)
     * @param action - Type of action to broadcast. Choose one, depending on what the user is about to receive: typing
     *               for text messages, upload_photo for photos, record_video or upload_video for videos, record_audio
     *               or upload_audio for audio files, upload_document for general files, find_location for location
     *               data.
     */
    @RequestLine("POST /sendChatAction?" +
                 "chat_id={chat}&" +
                 "action={action}")
    Response<Object> sendChatAction (@Param("chat") String chat,
                                     @Param("action") String action);

    /**
     * Use this method to receive incoming updates using long polling
     * (see wiki - http://en.wikipedia.org/wiki/Push_technology#Long_polling).
     * <p>
     * This method will not work if an outgoing webhook is set up.
     * <p>
     * In order to avoid getting duplicate updates, recalculate offset after each server response.
     *
     * @param offset  - Optional. Identifier of the first update to be returned. Must be greater by one than the highest
     *                among the identifiers of previously received updates. By default, updates starting with the
     *                earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates
     *                is called with an offset higher than its update_id.
     * @param limit   - Optional. Limits the number of updates to be retrieved. Values between 1—100 are accepted.
     *                Defaults to 100.
     * @param timeout - Optional. Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling.
     *
     * @return An list of {@link Update} objects is returned.
     */
    @RequestLine("GET /getUpdates?" +
                 "offset={offset}&" +
                 "limit={limit}&" +
                 "timeout={timeout}")
    Response<List<Update>> getUpdates (@Param("offset") Integer offset,
                                       @Param("limit") Integer limit,
                                       @Param("timeout") Integer timeout);

    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an
     * update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized
     * {@link Update}. In case of an unsuccessful request, we will give up after a reasonable amount of attempts.
     * <p>
     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the
     * URL, e.g. https://www.example.com/<token>. Since nobody else knows your bot‘s token, you can be pretty sure it’s
     * us.
     * <p>
     * Notes:
     * 1. You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.
     * 2. We currently do not support self-signed certificates.
     * 3. Ports currently supported for Webhooks: 443, 80, 88, 8443.
     *
     * @param url - Optional. HTTPS url to send updates to. Use an empty string to remove webhook integration
     */
    @RequestLine("POST /setWebhook?url={url}")
    Response<Object> setWebhook (@Param("url") String url);

}
