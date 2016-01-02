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
 * This object represents a message.
 *
 * @author Artem Labazin
 *
 * @since Jun 30, 2015 | 10:59:50 PM
 *
 * @version 1.0.0
 */
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Message implements Serializable {

    private static final long serialVersionUID = 1388508588959700748L;

    /**
     * Unique message identifier
     */
    @JsonProperty("message_id")
    private Integer id;

    /**
     * Optional. Sender, can be empty for messages sent to channels
     */
    private User from;

    /**
     * Date the message was sent in Unix time
     */
    private Integer date;

    /**
     * Conversation the message belongs to
     */
    private Chat chat;

    /**
     * Optional. For forwarded messages, sender of the original message
     */
    @JsonProperty("forward_from")
    private User forwardFrom;

    /**
     * Optional. For forwarded messages, date the original message was sent in Unix time
     */
    @JsonProperty("forward_date")
    private Integer forwardDate;

    /**
     * Optional. For replies, the original message. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it itself is a reply.
     */
    @JsonProperty("reply_to_message")
    private Message replyTo;

    /**
     * Optional. For text messages, the actual UTF-8 text of the message
     */
    private String text;

    /**
     * Optional. Message is a sticker, information about the sticker
     */
    private Sticker sticker;

    /**
     * Optional. Message is a shared contact, information about the contact
     */
    private Contact contact;

    /**
     * Optional. Message is a shared location, information about the location
     */
    private Location location;

    /**
     * Optional. A new member was added to the group, information about them (this member may be bot itself)
     */
    @JsonProperty("new_chat_participant")
    private User newMember;

    /**
     * Optional. A member was removed from the group, information about them (this member may be bot itself)
     */
    @JsonProperty("left_chat_participant")
    private User leftMember;

    /**
     * Optional. A group title was changed to this value
     */
    @JsonProperty("new_chat_title")
    private String newTitle;

    /**
     * Optional. A group photo was change to this value
     */
    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhoto;

    /**
     * Optional. Service message: the chat photo was deleted
     */
    @JsonProperty("delete_chat_photo")
    private boolean deleteChatPhoto;

    /**
     * Optional. Service message: the group has been created
     */
    @JsonProperty("group_chat_created")
    private boolean groupChatCreated;

    /**
     * Optional. Service message: the supergroup has been created
     */
    @JsonProperty("supergroup_chat_created")
    private boolean supergroupChatCreated;

    /**
     * Optional. Service message: the channel has been created
     */
    @JsonProperty("channel_chat_created")
    private boolean channelChatCreated;

    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier, not exceeding 1e13 by
     * absolute value
     */
    @JsonProperty("migrate_to_chat_id")
    private Integer migrateTo;

    /**
     * Optional. The supergroup has been migrated from a group with the specified identifier, not exceeding 1e13 by
     * absolute value
     */
    @JsonProperty("migrate_from_chat_id")
    private Integer migrateFrom;
}
