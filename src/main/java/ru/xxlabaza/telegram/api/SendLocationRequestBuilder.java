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

import java.math.BigDecimal;
import ru.xxlabaza.telegram.api.type.ForceReply;
import ru.xxlabaza.telegram.api.type.Message;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardHide;
import ru.xxlabaza.telegram.api.type.ReplyKeyboardMarkup;

/**
 * A request builder for sending point on the map.
 * <p>
 * On success, the sent {@link Message} is returned.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:27:55 AM
 *
 * @version 1.0.0
 */
public final class SendLocationRequestBuilder extends AbstractReplyRequestBuilder<Message> {

    private String chat;

    private BigDecimal latitude;

    private BigDecimal longitude;

    SendLocationRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Required value.
     *
     * @param chat unique identifier for the target chat or username of the target channel
     *             (in the format @channelusername)
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder chat (String chat) {
        this.chat = chat;
        return this;
    }

    /**
     * Required value.
     *
     * @param latitude latitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder latitude (BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Required value.
     *
     * @param latitude latitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder latitude (Integer latitude) {
        this.latitude = new BigDecimal(latitude);
        return this;
    }

    /**
     * Required value.
     *
     * @param latitude latitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder latitude (Long latitude) {
        this.latitude = new BigDecimal(latitude);
        return this;
    }

    /**
     * Required value.
     *
     * @param latitude latitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder latitude (Double latitude) {
        this.latitude = new BigDecimal(latitude.toString());
        return this;
    }

    /**
     * Required value.
     *
     * @param latitude latitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder latitude (Float latitude) {
        this.latitude = new BigDecimal(latitude.toString());
        return this;
    }

    /**
     * Required value.
     *
     * @param latitude latitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder latitude (String latitude) {
        this.latitude = new BigDecimal(latitude);
        return this;
    }

    /**
     * Required value.
     *
     * @param longitude longitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder longitude (BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Required value.
     *
     * @param longitude longitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder longitude (Integer longitude) {
        this.longitude = new BigDecimal(longitude);
        return this;
    }

    /**
     * Required value.
     *
     * @param longitude longitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder longitude (Long longitude) {
        this.longitude = new BigDecimal(longitude);
        return this;
    }

    /**
     * Required value.
     *
     * @param longitude longitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder longitude (Double longitude) {
        this.longitude = new BigDecimal(longitude.toString());
        return this;
    }

    /**
     * Required value.
     *
     * @param longitude longitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder longitude (Float longitude) {
        this.longitude = new BigDecimal(longitude.toString());
        return this;
    }

    /**
     * Required value.
     *
     * @param longitude longitude of location
     *
     * @return {@link SendLocationRequestBuilder} which builds request
     */
    public SendLocationRequestBuilder longitude (String longitude) {
        this.longitude = new BigDecimal(longitude);
        return this;
    }

    @Override
    public SendLocationRequestBuilder forceReply (ForceReply forceReply) {
        super.forceReply(forceReply);
        return this;
    }

    @Override
    public SendLocationRequestBuilder replyKeyboardHide (ReplyKeyboardHide replyKeyboardHide) {
        super.replyKeyboardHide(replyKeyboardHide);
        return this;
    }

    @Override
    public SendLocationRequestBuilder replyKeyboardMarkup (ReplyKeyboardMarkup replyKeyboardMarkup) {
        super.replyKeyboardMarkup(replyKeyboardMarkup);
        return this;
    }

    @Override
    public SendLocationRequestBuilder replyTo (Integer replyTo) {
        super.replyTo(replyTo);
        return this;
    }

    @Override
    protected Response<Message> getResponse () {
        if (chat == null) {
            throw new IllegalArgumentException("chat value is required");
        }
        if (latitude == null) {
            throw new IllegalArgumentException("latitude value is required");
        }
        if (longitude == null) {
            throw new IllegalArgumentException("longitude value is required");
        }

        if (replyKeyboardMarkup != null) {
            return api.sendLocation(chat, latitude, longitude, replyTo, replyKeyboardMarkup);
        } else if (replyKeyboardHide != null) {
            return api.sendLocation(chat, latitude, longitude, replyTo, replyKeyboardHide);
        } else {
            return api.sendLocation(chat, latitude, longitude, replyTo, forceReply);
        }
    }
}
