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

import java.util.List;
import ru.xxlabaza.telegram.api.type.Update;

/**
 * A request builder for receiving incoming updates using long polling.
 * <p>
 * On success, the sent {@link List} of {@link Update} is returned.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 9:01:22 AM
 *
 * @version 1.0.0
 */
public final class GetUpdatesRequestBuilder extends AbstractRequestBuilder<List<Update>> {

    private Integer offset;

    private Integer limit;

    private Integer timeout;

    GetUpdatesRequestBuilder (TelegramApi api) {
        super(api);
    }

    /**
     * Optional value.
     *
     * @param offset - identifier of the first update to be returned. Must be greater by one than the highest
     *               among the identifiers of previously received updates. By default, updates starting with the
     *               earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates
     *               is called with an offset higher than its update_id.
     *
     * @return {@link GetUpdatesRequestBuilder} which builds request
     */
    public GetUpdatesRequestBuilder offset (Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Optional value.
     *
     * @param limit - limits the number of updates to be retrieved. Values between 1—100 are accepted.
     *              Defaults to 100.
     *
     * @return {@link GetUpdatesRequestBuilder} which builds request
     */
    public GetUpdatesRequestBuilder limit (Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Optional value.
     *
     * @param timeout - timeout in seconds for long polling. Defaults to 0, i.e. usual short polling.
     *
     * @return {@link GetUpdatesRequestBuilder} which builds request
     */
    public GetUpdatesRequestBuilder timeout (Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    @Override
    protected Response<List<Update>> getResponse () {
        return api.getUpdates(offset, limit, timeout);
    }
}
