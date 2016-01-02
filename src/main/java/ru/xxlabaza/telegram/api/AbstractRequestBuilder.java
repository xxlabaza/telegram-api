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
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 8:59:34 AM
 *
 * @version 1.0.0
 */
abstract class AbstractRequestBuilder<T> implements RequestBuilder<T> {

    protected final TelegramApi api;

    protected AbstractRequestBuilder (TelegramApi api) {
        this.api = api;
    }

    /**
     * @return On success, the response is returned.
     */
    @Override
    public T call () {
        Response<T> response = getResponse();
        validate(response);
        return response.getResult();
    }

    protected abstract Response<T> getResponse ();

    protected void validate (Response<T> response) {
        if (response == null) {
            throw new RemoteApiException();
        }
        if (!response.getOk()) {
            throw new RemoteApiException(response.getError());
        }
    }
}
