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
import ru.xxlabaza.telegram.api.type.ReplyKeyboardHide;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardMarkup;

/**
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:31:55 AM
 *
 * @version 1.0.0
 */
abstract class AbstractReplyRequestBuilder<T> extends AbstractRequestBuilder<T> {

    protected Integer replyTo;

    protected ReplyKeyboardMarkup replyKeyboardMarkup;

    protected ReplyKeyboardHide replyKeyboardHide;

    protected ForceReply forceReply;

    AbstractReplyRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Optional value.
     *
     * @param replyTo - if the message is a reply, ID of the original message
     *
     * @return builder
     */
    public AbstractReplyRequestBuilder<T> replyTo (Integer replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    /**
     * Optional value. Only one value can be set <b>replyKeyboardMarkup</b>, <b>replyKeyboardHide</b> or
     * <b>forceReply</b>
     *
     * @param replyKeyboardMarkup - additional interface options. A JSON-serialized object for a custom reply keyboard
     *
     * @return builder
     *
     * @exception IllegalArgumentException if <b>replyKeyboardHide</b> or <b>forceReply</b> are already set.
     */
    public AbstractReplyRequestBuilder<T> replyKeyboardMarkup (ReplyKeyboardMarkup replyKeyboardMarkup
    ) throws IllegalArgumentException {
        if (replyKeyboardHide != null || forceReply != null) {
            throw new IllegalArgumentException("replyKeyboardHide or forceReply are already set");
        }
        this.replyKeyboardMarkup = replyKeyboardMarkup;
        return this;
    }

    /**
     * Optional value. Only one value can be set <b>replyKeyboardMarkup</b>, <b>replyKeyboardHide</b> or
     * <b>forceReply</b>
     *
     * @param replyKeyboardHide - additional interface options. A JSON-serialized object for a instructions to hide
     *                          keyboard
     *
     * @return builder
     *
     * @exception IllegalArgumentException if <b>replyKeyboardMarkup</b> or <b>forceReply</b> are already set.
     */
    public AbstractReplyRequestBuilder<T> replyKeyboardHide (ReplyKeyboardHide replyKeyboardHide
    ) throws IllegalArgumentException {
        if (replyKeyboardMarkup != null || forceReply != null) {
            throw new IllegalArgumentException("replyKeyboardMarkup or forceReply are already set");
        }
        this.replyKeyboardHide = replyKeyboardHide;
        return this;
    }

    /**
     * Optional value. Only one value can be set <b>replyKeyboardMarkup</b>, <b>replyKeyboardHide</b> or
     * <b>forceReply</b>
     *
     * @param forceReply - additional interface options. A JSON-serialized object to force a reply from the user
     *
     * @return builder
     *
     * @exception IllegalArgumentException if <b>replyKeyboardMarkup</b> or <b>replyKeyboardHide</b> are already set.
     */
    public AbstractReplyRequestBuilder<T> forceReply (ForceReply forceReply
    ) throws IllegalArgumentException {
        if (replyKeyboardHide != null || replyKeyboardMarkup != null) {
            throw new IllegalArgumentException("replyKeyboardMarkup or replyKeyboardHide are already set");
        }
        this.forceReply = forceReply;
        return this;
    }
}
