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

public class ResponsePublicKeys extends Response {

    public static final int HEADER = 0xa2a;
    public static ResponsePublicKeys fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponsePublicKeys(), data);
    }

    private List<ApiEncryptionKey> publicKey;
    private List<ApiEncryptionKeySignature> signatures;

    public ResponsePublicKeys(@NotNull List<ApiEncryptionKey> publicKey, @NotNull List<ApiEncryptionKeySignature> signatures) {
        this.publicKey = publicKey;
        this.signatures = signatures;
    }

    public ResponsePublicKeys() {

    }

    @NotNull
    public List<ApiEncryptionKey> getPublicKey() {
        return this.publicKey;
    }

    @NotNull
    public List<ApiEncryptionKeySignature> getSignatures() {
        return this.signatures;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiEncryptionKey> _publicKey = new ArrayList<ApiEncryptionKey>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _publicKey.add(new ApiEncryptionKey());
        }
        this.publicKey = values.getRepeatedObj(1, _publicKey);
        List<ApiEncryptionKeySignature> _signatures = new ArrayList<ApiEncryptionKeySignature>();
        for (int i = 0; i < values.getRepeatedCount(2); i ++) {
            _signatures.add(new ApiEncryptionKeySignature());
        }
        this.signatures = values.getRepeatedObj(2, _signatures);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.publicKey);
        writer.writeRepeatedObj(2, this.signatures);
    }

    @Override
    public String toString() {
        String res = "response PublicKeys{";
        res += "publicKey=" + this.publicKey;
        res += ", signatures=" + this.signatures;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
