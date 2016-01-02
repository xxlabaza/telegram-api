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
import java.util.List;
import lombok.Data;

/**
 * This object represents a custom keyboard with reply options.
 * See Introduction to bots for details and examples:
 * https://core.telegram.org/bots#keyboards
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 1:08:00 AM
 *
 * @version 1.0.0
 */
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class ReplyKeyboardMarkup implements Serializable {

    private static final long serialVersionUID = 8146957567409962861L;

    /**
     * Array of button rows, each represented by an Array of Strings
     */
    private List<List<String>> keyboard;

    /**
     * Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if
     * there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the same
     * height as the app's standard keyboard.
     */
    @JsonProperty("resize_keyboard")
    private boolean resize;

    /**
     * Optional. Requests clients to hide the keyboard as soon as it's been used. Defaults to false.
     */
    @JsonProperty("one_time_keyboard")
    private boolean autoHide;

    /**
     * Optional. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are
     * mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id),
     * sender of the original message.
     * <p>
     * Example: A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the
     * new language. Other users in the group don’t see the keyboard.
     */
    private boolean selective;
}
