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

public class RequestSearchContacts extends Request<ResponseSearchContacts> {

    public static final int HEADER = 0x70;
    public static RequestSearchContacts fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestSearchContacts(), data);
    }

    private String request;
    private List<ApiUpdateOptimization> optimizations;

    public RequestSearchContacts(@NotNull String request, @NotNull List<ApiUpdateOptimization> optimizations) {
        this.request = request;
        this.optimizations = optimizations;
    }

    public RequestSearchContacts() {

    }

    @NotNull
    public String getRequest() {
        return this.request;
    }

    @NotNull
    public List<ApiUpdateOptimization> getOptimizations() {
        return this.optimizations;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.request = values.getString(1);
        this.optimizations = new ArrayList<ApiUpdateOptimization>();
        for (int b : values.getRepeatedInt(2)) {
            optimizations.add(ApiUpdateOptimization.parse(b));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.request == null) {
            throw new IOException();
        }
        writer.writeString(1, this.request);
        for (ApiUpdateOptimization i : this.optimizations) {
            writer.writeInt(2, i.getValue());
        }
    }

    @Override
    public String toString() {
        String res = "rpc SearchContacts{";
        res += "request=" + this.request;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
