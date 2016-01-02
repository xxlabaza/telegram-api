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
 * A request builder for specifying an url and receive incoming updates via an outgoing webhook.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:05:10 AM
 *
 * @version 1.0.0
 */
public final class SetWebhookRequestBuilder extends AbstractRequestBuilder<Object> {

    private String url;

    SetWebhookRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Optional value.
     *
     * @param url - HTTPS url to send updates to. Use an empty string to remove webhook integration
     *
     * @return {@link SetWebhookRequestBuilder} which builds request
     */
    public SetWebhookRequestBuilder url (String url) {
        this.url = url;
        return this;
    }

    @Override
    protected Response<Object> getResponse () {
        return api.setWebhook(url);
    }
}
