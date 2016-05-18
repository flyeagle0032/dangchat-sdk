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

public class RequestSendAuthCallObsolete extends Request<ResponseVoid> {

    public static final int HEADER = 0x5a;
    public static RequestSendAuthCallObsolete fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestSendAuthCallObsolete(), data);
    }

    private long phoneNumber;
    private String smsHash;
    private int appId;
    private String apiKey;

    public RequestSendAuthCallObsolete(long phoneNumber, @NotNull String smsHash, int appId, @NotNull String apiKey) {
        this.phoneNumber = phoneNumber;
        this.smsHash = smsHash;
        this.appId = appId;
        this.apiKey = apiKey;
    }

    public RequestSendAuthCallObsolete() {

    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    @NotNull
    public String getSmsHash() {
        return this.smsHash;
    }

    public int getAppId() {
        return this.appId;
    }

    @NotNull
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.phoneNumber = values.getLong(1);
        this.smsHash = values.getString(2);
        this.appId = values.getInt(3);
        this.apiKey = values.getString(4);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.phoneNumber);
        if (this.smsHash == null) {
            throw new IOException();
        }
        writer.writeString(2, this.smsHash);
        writer.writeInt(3, this.appId);
        if (this.apiKey == null) {
            throw new IOException();
        }
        writer.writeString(4, this.apiKey);
    }

    @Override
    public String toString() {
        String res = "rpc SendAuthCallObsolete{";
        res += "phoneNumber=" + this.phoneNumber;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
