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

public class RequestGetFileUrlBuilder extends Request<ResponseGetFileUrlBuilder> {

    public static final int HEADER = 0xa13;
    public static RequestGetFileUrlBuilder fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestGetFileUrlBuilder(), data);
    }

    private List<String> supportedSignatureAlgorithms;

    public RequestGetFileUrlBuilder(@NotNull List<String> supportedSignatureAlgorithms) {
        this.supportedSignatureAlgorithms = supportedSignatureAlgorithms;
    }

    public RequestGetFileUrlBuilder() {

    }

    @NotNull
    public List<String> getSupportedSignatureAlgorithms() {
        return this.supportedSignatureAlgorithms;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.supportedSignatureAlgorithms = values.getRepeatedString(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedString(1, this.supportedSignatureAlgorithms);
    }

    @Override
    public String toString() {
        String res = "rpc GetFileUrlBuilder{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
