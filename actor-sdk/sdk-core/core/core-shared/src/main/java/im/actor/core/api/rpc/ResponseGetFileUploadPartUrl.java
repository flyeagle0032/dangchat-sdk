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

public class ResponseGetFileUploadPartUrl extends Response {

    public static final int HEADER = 0x8d;
    public static ResponseGetFileUploadPartUrl fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseGetFileUploadPartUrl(), data);
    }

    private String url;

    public ResponseGetFileUploadPartUrl(@NotNull String url) {
        this.url = url;
    }

    public ResponseGetFileUploadPartUrl() {

    }

    @NotNull
    public String getUrl() {
        return this.url;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.url = values.getString(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.url == null) {
            throw new IOException();
        }
        writer.writeString(1, this.url);
    }

    @Override
    public String toString() {
        String res = "tuple GetFileUploadPartUrl{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
