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

import ru.xxlabaza.telegram.api.type.ForceReply;
import ru.xxlabaza.telegram.api.type.Message;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardHide;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardMarkup;

/**
 * A request builder for sending text messages.
 * <p>
 * On success, the sent {@link Message} is returned.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:02:49 AM
 *
 * @version 1.0.0
 */
public final class SendMessageRequestBuilder extends AbstractReplyRequestBuilder<Message> {

    private String chat;

    private String text;

    private String mode;

    private boolean disablePreview;

    SendMessageRequestBuilder (TelegramApi api) {
        super(api);
        disablePreview = false;
    }

    /**
     * Required value.
     *
     * @param chat - unique identifier for the target chat or username of the target channel
     *             (in the format @channelusername)
     *
     * @return {@link SendMessageRequestBuilder} which builds request
     */
    public SendMessageRequestBuilder chat (String chat) {
        this.chat = chat;
        return this;
    }

    /**
     * Required value.
     *
     * @param text - text of the message to be sent
     *
     * @return {@link SendMessageRequestBuilder} which builds request
     */
    public SendMessageRequestBuilder text (String text) {
        this.text = text;
        return this;
    }

    /**
     * Optional value.
     *
     * @param mode - send Markdown, if you want Telegram apps to show bold, italic and inline URLs in your bot's message
     *
     * @return {@link SendMessageRequestBuilder} which builds request
     */
    public SendMessageRequestBuilder mode (String mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Optional value. Disables link previews for links in this message
     *
     * @return {@link SendMessageRequestBuilder} which builds request
     */
    public SendMessageRequestBuilder disableWebPagePreview () {
        disablePreview = true;
        return this;
    }

    @Override
    public SendMessageRequestBuilder forceReply (ForceReply forceReply
    ) throws IllegalArgumentException {
        super.forceReply(forceReply);
        return this;
    }

    @Override
    public SendMessageRequestBuilder replyKeyboardHide (ReplyKeyboardHide replyKeyboardHide
    ) throws IllegalArgumentException {
        super.replyKeyboardHide(replyKeyboardHide);
        return this;
    }

    @Override
    public SendMessageRequestBuilder replyKeyboardMarkup (ReplyKeyboardMarkup replyKeyboardMarkup
    ) throws IllegalArgumentException {
        super.replyKeyboardMarkup(replyKeyboardMarkup);
        return this;
    }

    @Override
    public SendMessageRequestBuilder replyTo (Integer replyTo) {
        super.replyTo(replyTo);
        return this;
    }

    @Override
    protected Response<Message> getResponse () {
        if (chat == null) {
            throw new IllegalArgumentException("chat value is required");
        }
        if (text == null) {
            throw new IllegalArgumentException("text value is required");
        }

        if (replyKeyboardMarkup != null) {
            return api.sendMessage(chat, text, mode, disablePreview, replyTo, replyKeyboardMarkup);
        } else if (replyKeyboardHide != null) {
            return api.sendMessage(chat, text, mode, disablePreview, replyTo, replyKeyboardHide);
        } else {
            return api.sendMessage(chat, text, mode, disablePreview, replyTo, forceReply);
        }
    }
}
