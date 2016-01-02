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
 * A request builder for sending stickers.
 * <p>
 * On success, the sent {@link Message} is returned.
 *
 * @author Artem Labazin
 * <p>
 * @since Jan 2, 2016 | 8:10:25 PM
 * <p>
 * @version 1.0.0
 */
public final class SendStickerRequestBuilder extends AbstractReplyRequestBuilder<Message> {

    private String chat;

    private String sticker;

    SendStickerRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Required value.
     *
     * @param chat - unique identifier for the target chat or username of the target channel
     *             (in the format @channelusername)
     *
     * @return {@link SendStickerRequestBuilder} which builds request
     */
    public SendStickerRequestBuilder chat (String chat) {
        this.chat = chat;
        return this;
    }

    /**
     * Required value.
     *
     * @param sticker - sticker to send. You can pass a file_id as String to resend a sticker that is already on
     *                the Telegram servers.
     *
     * @return {@link SendStickerRequestBuilder} which builds request
     */
    public SendStickerRequestBuilder sticker (String sticker) {
        this.sticker = sticker;
        return this;
    }

    @Override
    public SendStickerRequestBuilder forceReply (ForceReply forceReply) {
        super.forceReply(forceReply);
        return this;
    }

    @Override
    public SendStickerRequestBuilder replyKeyboardHide (ReplyKeyboardHide replyKeyboardHide) {
        super.replyKeyboardHide(replyKeyboardHide);
        return this;
    }

    @Override
    public SendStickerRequestBuilder replyKeyboardMarkup (ReplyKeyboardMarkup replyKeyboardMarkup) {
        super.replyKeyboardMarkup(replyKeyboardMarkup);
        return this;
    }

    @Override
    public SendStickerRequestBuilder replyTo (Integer replyTo) {
        super.replyTo(replyTo);
        return this;
    }

    @Override
    protected Response<Message> getResponse () {
        if (chat == null) {
            throw new IllegalArgumentException("chat value is required");
        }
        if (sticker == null) {
            throw new IllegalArgumentException("sticker value is required");
        }

        if (replyKeyboardMarkup != null) {
            return api.sendSticker(chat, sticker, replyTo, replyKeyboardMarkup);
        } else if (replyKeyboardHide != null) {
            return api.sendSticker(chat, sticker, replyTo, replyKeyboardHide);
        } else {
            return api.sendSticker(chat, sticker, replyTo, forceReply);
        }
    }
}
