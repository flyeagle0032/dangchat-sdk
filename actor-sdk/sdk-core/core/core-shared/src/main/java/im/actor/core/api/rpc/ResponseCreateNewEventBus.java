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

public class ResponseCreateNewEventBus extends Response {

    public static final int HEADER = 0xa6a;
    public static ResponseCreateNewEventBus fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseCreateNewEventBus(), data);
    }

    private String id;
    private long deviceId;

    public ResponseCreateNewEventBus(@NotNull String id, long deviceId) {
        this.id = id;
        this.deviceId = deviceId;
    }

    public ResponseCreateNewEventBus() {

    }

    @NotNull
    public String getId() {
        return this.id;
    }

    public long getDeviceId() {
        return this.deviceId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getString(1);
        this.deviceId = values.getLong(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.id == null) {
            throw new IOException();
        }
        writer.writeString(1, this.id);
        writer.writeLong(2, this.deviceId);
    }

    @Override
    public String toString() {
        String res = "tuple CreateNewEventBus{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
