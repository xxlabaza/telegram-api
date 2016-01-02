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
package ru.xxlabaza.telegram.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * This object represents a chat.
 *
 * @author Artem Labazin
 * <p>
 * @since Jan 2, 2016 | 6:20:05 PM
 * <p>
 * @version 1.0.0
 */
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Chat implements Serializable {

    private static final long serialVersionUID = 8723731071852618200L;

    /**
     * Unique identifier for this chat, not exceeding 1e13 by absolute value
     */
    private Integer id;

    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    private String type;

    /**
     * Optional. Title, for channels and group chats
     */
    private String title;

    /**
     * Optional. Username, for private chats and channels if available
     */
    private String username;

    /**
     * Optional. First name of the other party in a private chat
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Optional. Last name of the other party in a private chat
     */
    @JsonProperty("last_name")
    private String lastName;
}
