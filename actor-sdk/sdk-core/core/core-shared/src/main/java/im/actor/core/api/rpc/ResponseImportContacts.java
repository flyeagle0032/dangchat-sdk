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

public class ResponseImportContacts extends Response {

    public static final int HEADER = 0x8;
    public static ResponseImportContacts fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseImportContacts(), data);
    }

    private List<ApiUser> users;
    private int seq;
    private byte[] state;
    private List<ApiUserOutPeer> userPeers;

    public ResponseImportContacts(@NotNull List<ApiUser> users, int seq, @NotNull byte[] state, @NotNull List<ApiUserOutPeer> userPeers) {
        this.users = users;
        this.seq = seq;
        this.state = state;
        this.userPeers = userPeers;
    }

    public ResponseImportContacts() {

    }

    @NotNull
    public List<ApiUser> getUsers() {
        return this.users;
    }

    public int getSeq() {
        return this.seq;
    }

    @NotNull
    public byte[] getState() {
        return this.state;
    }

    @NotNull
    public List<ApiUserOutPeer> getUserPeers() {
        return this.userPeers;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiUser> _users = new ArrayList<ApiUser>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _users.add(new ApiUser());
        }
        this.users = values.getRepeatedObj(1, _users);
        this.seq = values.getInt(2);
        this.state = values.getBytes(3);
        List<ApiUserOutPeer> _userPeers = new ArrayList<ApiUserOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(4); i ++) {
            _userPeers.add(new ApiUserOutPeer());
        }
        this.userPeers = values.getRepeatedObj(4, _userPeers);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.users);
        writer.writeInt(2, this.seq);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeBytes(3, this.state);
        writer.writeRepeatedObj(4, this.userPeers);
    }

    @Override
    public String toString() {
        String res = "tuple ImportContacts{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
