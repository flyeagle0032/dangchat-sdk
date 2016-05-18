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

public class RequestCreateNewKeyGroup extends Request<ResponseCreateNewKeyGroup> {

    public static final int HEADER = 0xa31;
    public static RequestCreateNewKeyGroup fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestCreateNewKeyGroup(), data);
    }

    private ApiEncryptionKey identityKey;
    private List<String> supportedEncryptions;
    private List<ApiEncryptionKey> keys;
    private List<ApiEncryptionKeySignature> signatures;

    public RequestCreateNewKeyGroup(@NotNull ApiEncryptionKey identityKey, @NotNull List<String> supportedEncryptions, @NotNull List<ApiEncryptionKey> keys, @NotNull List<ApiEncryptionKeySignature> signatures) {
        this.identityKey = identityKey;
        this.supportedEncryptions = supportedEncryptions;
        this.keys = keys;
        this.signatures = signatures;
    }

    public RequestCreateNewKeyGroup() {

    }

    @NotNull
    public ApiEncryptionKey getIdentityKey() {
        return this.identityKey;
    }

    @NotNull
    public List<String> getSupportedEncryptions() {
        return this.supportedEncryptions;
    }

    @NotNull
    public List<ApiEncryptionKey> getKeys() {
        return this.keys;
    }

    @NotNull
    public List<ApiEncryptionKeySignature> getSignatures() {
        return this.signatures;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.identityKey = values.getObj(1, new ApiEncryptionKey());
        this.supportedEncryptions = values.getRepeatedString(2);
        List<ApiEncryptionKey> _keys = new ArrayList<ApiEncryptionKey>();
        for (int i = 0; i < values.getRepeatedCount(3); i ++) {
            _keys.add(new ApiEncryptionKey());
        }
        this.keys = values.getRepeatedObj(3, _keys);
        List<ApiEncryptionKeySignature> _signatures = new ArrayList<ApiEncryptionKeySignature>();
        for (int i = 0; i < values.getRepeatedCount(4); i ++) {
            _signatures.add(new ApiEncryptionKeySignature());
        }
        this.signatures = values.getRepeatedObj(4, _signatures);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.identityKey == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.identityKey);
        writer.writeRepeatedString(2, this.supportedEncryptions);
        writer.writeRepeatedObj(3, this.keys);
        writer.writeRepeatedObj(4, this.signatures);
    }

    @Override
    public String toString() {
        String res = "rpc CreateNewKeyGroup{";
        res += "identityKey=" + this.identityKey;
        res += ", supportedEncryptions=" + this.supportedEncryptions;
        res += ", keys=" + this.keys;
        res += ", signatures=" + this.signatures;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
