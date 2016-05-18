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

public class RequestGetContacts extends Request<ResponseGetContacts> {

    public static final int HEADER = 0x57;
    public static RequestGetContacts fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestGetContacts(), data);
    }

    private String contactsHash;
    private List<ApiUpdateOptimization> optimizations;

    public RequestGetContacts(@NotNull String contactsHash, @NotNull List<ApiUpdateOptimization> optimizations) {
        this.contactsHash = contactsHash;
        this.optimizations = optimizations;
    }

    public RequestGetContacts() {

    }

    @NotNull
    public String getContactsHash() {
        return this.contactsHash;
    }

    @NotNull
    public List<ApiUpdateOptimization> getOptimizations() {
        return this.optimizations;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.contactsHash = values.getString(1);
        this.optimizations = new ArrayList<ApiUpdateOptimization>();
        for (int b : values.getRepeatedInt(2)) {
            optimizations.add(ApiUpdateOptimization.parse(b));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.contactsHash == null) {
            throw new IOException();
        }
        writer.writeString(1, this.contactsHash);
        for (ApiUpdateOptimization i : this.optimizations) {
            writer.writeInt(2, i.getValue());
        }
    }

    @Override
    public String toString() {
        String res = "rpc GetContacts{";
        res += "contactsHash=" + this.contactsHash;
        res += ", optimizations=" + this.optimizations;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
