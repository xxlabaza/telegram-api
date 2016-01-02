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

import ru.xxlabaza.telegram.api.type.User;

/**
 * A simple request builder for testing your bot's auth token. Requires no parameters.
 * <p>
 * It returns basic information about the bot in form of a {@link User} object.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:06:24 AM
 *
 * @version 1.0.0
 */
public final class GetMeRequestBuilder extends AbstractRequestBuilder<User> {

    GetMeRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Simple call for getting self bot's information.
     *
     * @return Returns basic information about the bot in form of a {@link User} object.
     */
    @Override
    protected Response<User> getResponse () {
        return api.getMe();
    }
}
