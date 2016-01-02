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

/**
 * A request builder for telling the user that something is happening on the bot's side.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:18:00 AM
 *
 * @version 1.0.0
 */
public final class SendChatActionRequestBuilder extends AbstractRequestBuilder<Object> {

    private String chat;

    private String action;

    SendChatActionRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Required value.
     *
     * @param chat - unique identifier for the target chat or username of the target channel
     *             (in the format @channelusername)
     *
     * @return {@link SendChatActionRequestBuilder} which builds request
     */
    public SendChatActionRequestBuilder chat (String chat) {
        this.chat = chat;
        return this;
    }

    /**
     * Required value.
     *
     * @param action - type of action to broadcast. Choose one, depending on what the user is about to receive: typing
     *               for text messages, upload_photo for photos, record_video or upload_video for videos, record_audio
     *               or upload_audio for audio files, upload_document for general files, find_location for location
     *               data.
     *
     * @return {@link SendChatActionRequestBuilder} which builds request
     */
    public SendChatActionRequestBuilder action (String action) {
        this.action = action;
        return this;
    }

    @Override
    protected Response<Object> getResponse () {
        if (chat == null) {
            throw new IllegalArgumentException("chat value is required");
        }
        if (action == null) {
            throw new IllegalArgumentException("action value is required");
        }

        return api.sendChatAction(chat, action);
    }
}
