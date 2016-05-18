package im.actor.core.api.updates;
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
import im.actor.core.api.*;

public class UpdateMessageReceived extends Update {

    public static final int HEADER = 0x36;
    public static UpdateMessageReceived fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateMessageReceived(), data);
    }

    private ApiPeer peer;
    private long startDate;
    private long receivedDate;

    public UpdateMessageReceived(@NotNull ApiPeer peer, long startDate, long receivedDate) {
        this.peer = peer;
        this.startDate = startDate;
        this.receivedDate = receivedDate;
    }

    public UpdateMessageReceived() {

    }

    @NotNull
    public ApiPeer getPeer() {
        return this.peer;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public long getReceivedDate() {
        return this.receivedDate;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiPeer());
        this.startDate = values.getLong(2);
        this.receivedDate = values.getLong(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
        writer.writeLong(2, this.startDate);
        writer.writeLong(3, this.receivedDate);
    }

    @Override
    public String toString() {
        String res = "update MessageReceived{";
        res += "peer=" + this.peer;
        res += ", startDate=" + this.startDate;
        res += ", receivedDate=" + this.receivedDate;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
