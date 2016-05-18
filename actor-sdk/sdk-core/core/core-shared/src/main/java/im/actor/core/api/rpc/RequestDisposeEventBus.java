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

public class RequestDisposeEventBus extends Request<ResponseVoid> {

    public static final int HEADER = 0xa6b;
    public static RequestDisposeEventBus fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestDisposeEventBus(), data);
    }

    private String id;

    public RequestDisposeEventBus(@NotNull String id) {
        this.id = id;
    }

    public RequestDisposeEventBus() {

    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getString(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.id == null) {
            throw new IOException();
        }
        writer.writeString(1, this.id);
    }

    @Override
    public String toString() {
        String res = "rpc DisposeEventBus{";
        res += "id=" + this.id;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
