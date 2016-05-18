package im.actor.core.api.rpc;
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

public class ResponseDoCall extends Response {

    public static final int HEADER = 0xa26;
    public static ResponseDoCall fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseDoCall(), data);
    }

    private long callId;
    private String eventBusId;
    private long deviceId;

    public ResponseDoCall(long callId, @NotNull String eventBusId, long deviceId) {
        this.callId = callId;
        this.eventBusId = eventBusId;
        this.deviceId = deviceId;
    }

    public ResponseDoCall() {

    }

    public long getCallId() {
        return this.callId;
    }

    @NotNull
    public String getEventBusId() {
        return this.eventBusId;
    }

    public long getDeviceId() {
        return this.deviceId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.callId = values.getLong(1);
        this.eventBusId = values.getString(2);
        this.deviceId = values.getLong(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.callId);
        if (this.eventBusId == null) {
            throw new IOException();
        }
        writer.writeString(2, this.eventBusId);
        writer.writeLong(3, this.deviceId);
    }

    @Override
    public String toString() {
        String res = "tuple DoCall{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
