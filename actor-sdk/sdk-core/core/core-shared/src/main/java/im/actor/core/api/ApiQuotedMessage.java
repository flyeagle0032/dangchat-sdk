package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ApiQuotedMessage extends BserObject {

    private Long messageId;
    private Integer publicGroupId;
    private int senderUserId;
    private long messageDate;
    private ApiMessage quotedMessageContent;

    public ApiQuotedMessage(@Nullable Long messageId, @Nullable Integer publicGroupId, int senderUserId, long messageDate, @Nullable ApiMessage quotedMessageContent) {
        this.messageId = messageId;
        this.publicGroupId = publicGroupId;
        this.senderUserId = senderUserId;
        this.messageDate = messageDate;
        this.quotedMessageContent = quotedMessageContent;
    }

    public ApiQuotedMessage() {

    }

    @Nullable
    public Long getMessageId() {
        return this.messageId;
    }

    @Nullable
    public Integer getPublicGroupId() {
        return this.publicGroupId;
    }

    public int getSenderUserId() {
        return this.senderUserId;
    }

    public long getMessageDate() {
        return this.messageDate;
    }

    @Nullable
    public ApiMessage getQuotedMessageContent() {
        return this.quotedMessageContent;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.messageId = values.optLong(1);
        this.publicGroupId = values.optInt(2);
        this.senderUserId = values.getInt(3);
        this.messageDate = values.getLong(4);
        if (values.optBytes(5) != null) {
            this.quotedMessageContent = ApiMessage.fromBytes(values.getBytes(5));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.messageId != null) {
            writer.writeLong(1, this.messageId);
        }
        if (this.publicGroupId != null) {
            writer.writeInt(2, this.publicGroupId);
        }
        writer.writeInt(3, this.senderUserId);
        writer.writeLong(4, this.messageDate);
        if (this.quotedMessageContent != null) {
            writer.writeBytes(5, this.quotedMessageContent.buildContainer());
        }
    }

    @Override
    public String toString() {
        String res = "struct QuotedMessage{";
        res += "messageId=" + this.messageId;
        res += ", publicGroupId=" + this.publicGroupId;
        res += ", senderUserId=" + this.senderUserId;
        res += ", messageDate=" + this.messageDate;
        res += ", quotedMessageContent=" + this.quotedMessageContent;
        res += "}";
        return res;
    }

}
