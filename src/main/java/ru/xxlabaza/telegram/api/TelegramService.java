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

import feign.Feign;
import feign.Logger;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;

/**
 * A service for working with Telegram API.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 8:23:19 AM
 *
 * @version 1.0.0
 */
public final class TelegramService {

    @Getter
    private static final String URL;

    static {
        URL = "https://api.telegram.org/bot";
    }

    private final TelegramApi api;

    /**
     * @param token a unique bot's authentication token
     */
    public TelegramService (String token) {
        api = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(TelegramApi.class, URL + token);
    }

    /**
     * @param token   a unique bot's authentication token
     * @param logFile path to log file
     */
    public TelegramService (String token, String logFile) {
        api = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Logger.JavaLogger().appendToFile(logFile))
                .logLevel(Level.FULL)
                .target(TelegramApi.class, URL + token);
    }

    /**
     * A simple method for testing your bot's auth token. Requires no parameters.
     *
     * @return {@link GetMeRequestBuilder} which builds request
     */
    public GetMeRequestBuilder getMe () {
        return new GetMeRequestBuilder(api);
    }

    /**
     * Use this method to send text messages.
     *
     * @return {@link SendMessageRequestBuilder} which builds request
     */
    public SendMessageRequestBuilder sendMessage () {
        return new SendMessageRequestBuilder(api);
    }

    /**
     * Use this method to forward messages of any kind.
     *
     * @return {@link ForwardMessageRequestBuilder} which builds request
     */
    public ForwardMessageRequestBuilder forwardMessage () {
        return new ForwardMessageRequestBuilder(api);
    }

    /**
     * Use this method to send .webp stickers.
     *
     * @return {@link SendStickerRequestBuilder} which builds request
     */
    public SendStickerRequestBuilder sendSticker () {
        return new SendStickerRequestBuilder(api);
    }

    /**
     * Use this method to send point on the map.
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder sendLocation () {
        return new SendLocationRequestBuilder(api);
    }

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
     * @return {@link SendChatActionRequestBuilder} which builds request
     */
    public SendChatActionRequestBuilder sendChatAction () {
        return new SendChatActionRequestBuilder(api);
    }

    /**
     * Use this method to receive incoming updates using long polling
     * (see wiki - http://en.wikipedia.org/wiki/Push_technology#Long_polling).
     * <p>
     * This method will not work if an outgoing webhook is set up.
     * <p>
     * In order to avoid getting duplicate updates, recalculate offset after each server response.
     *
     * @return {@link GetUpdatesRequestBuilder} which builds request
     */
    public GetUpdatesRequestBuilder getUpdates () {
        return new GetUpdatesRequestBuilder(api);
    }

    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an
     * update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized
     * {@link ru.xxlabaza.telegram.api.type.Update}. In case of an unsuccessful request, we will give up after a
     * reasonable amount of attempts.
     * <p>
     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the
     * URL, e.g. https://www.example.com/[token]. Since nobody else knows your bot‘s token, you can be pretty sure it’s
     * us.
     * <p>
     * Notes:
     * 1. You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.
     * 2. We currently do not support self-signed certificates.
     * 3. Ports currently supported for Webhooks: 443, 80, 88, 8443.
     *
     * @return {@link SetWebhookRequestBuilder} which builds request
     */
    public SetWebhookRequestBuilder setWebhook () {
        return new SetWebhookRequestBuilder(api);
    }
}
