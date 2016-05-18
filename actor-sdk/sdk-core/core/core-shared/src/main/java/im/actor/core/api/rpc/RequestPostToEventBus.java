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

public class RequestPostToEventBus extends Request<ResponseVoid> {

    public static final int HEADER = 0xa6f;
    public static RequestPostToEventBus fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestPostToEventBus(), data);
    }

    private String id;
    private List<Long> destinations;
    private byte[] message;

    public RequestPostToEventBus(@NotNull String id, @NotNull List<Long> destinations, @NotNull byte[] message) {
        this.id = id;
        this.destinations = destinations;
        this.message = message;
    }

    public RequestPostToEventBus() {

    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public List<Long> getDestinations() {
        return this.destinations;
    }

    @NotNull
    public byte[] getMessage() {
        return this.message;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getString(1);
        this.destinations = values.getRepeatedLong(2);
        this.message = values.getBytes(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.id == null) {
            throw new IOException();
        }
        writer.writeString(1, this.id);
        writer.writeRepeatedLong(2, this.destinations);
        if (this.message == null) {
            throw new IOException();
        }
        writer.writeBytes(3, this.message);
    }

    @Override
    public String toString() {
        String res = "rpc PostToEventBus{";
        res += "id=" + this.id;
        res += ", destinations=" + this.destinations;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
