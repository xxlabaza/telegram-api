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

import ru.xxlabaza.telegram.api.type.Message;

/**
 * A request builder for forwarding messages.
 * <p>
 * On success, the sent {@link Message} is returned.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:42:27 AM
 *
 * @version 1.0.0
 */
public final class ForwardMessageRequestBuilder extends AbstractRequestBuilder<Message> {

    private String chat;

    private String fromChat;

    private Integer message;

    ForwardMessageRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Required value.
     *
     * @param chat unique identifier for the target chat or username of the target channel
     *             (in the format @channelusername)
     *
     * @return {@link ForwardMessageRequestBuilder} which builds request
     */
    public ForwardMessageRequestBuilder chat (String chat) {
        this.chat = chat;
        return this;
    }

    /**
     * Required value.
     *
     * @param fromChat unique identifier for the chat where the original message was sent
     *                 (or channel username in the format @channelusername)
     *
     * @return {@link ForwardMessageRequestBuilder} which builds request
     */
    public ForwardMessageRequestBuilder fromChat (String fromChat) {
        this.fromChat = fromChat;
        return this;
    }

    /**
     * Required value.
     *
     * @param message unique message identifier
     *
     * @return {@link ForwardMessageRequestBuilder} which builds request
     */
    public ForwardMessageRequestBuilder message (Integer message) {
        this.message = message;
        return this;
    }

    @Override
    protected Response<Message> getResponse () {
        if (chat == null) {
            throw new IllegalArgumentException("chat value is required");
        }
        if (fromChat == null) {
            throw new IllegalArgumentException("fromChat value is required");
        }
        if (message == null) {
            throw new IllegalArgumentException("message value is required");
        }
        return api.forwardMessage(chat, fromChat, message);
    }
}
