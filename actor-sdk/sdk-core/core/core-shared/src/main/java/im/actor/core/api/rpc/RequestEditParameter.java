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

public class RequestEditParameter extends Request<ResponseSeq> {

    public static final int HEADER = 0x80;
    public static RequestEditParameter fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestEditParameter(), data);
    }

    private String key;
    private String value;

    public RequestEditParameter(@NotNull String key, @Nullable String value) {
        this.key = key;
        this.value = value;
    }

    public RequestEditParameter() {

    }

    @NotNull
    public String getKey() {
        return this.key;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.key = values.getString(1);
        this.value = values.optString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.key == null) {
            throw new IOException();
        }
        writer.writeString(1, this.key);
        if (this.value != null) {
            writer.writeString(2, this.value);
        }
    }

    @Override
    public String toString() {
        String res = "rpc EditParameter{";
        res += "key=" + this.key;
        res += ", value=" + this.value;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
