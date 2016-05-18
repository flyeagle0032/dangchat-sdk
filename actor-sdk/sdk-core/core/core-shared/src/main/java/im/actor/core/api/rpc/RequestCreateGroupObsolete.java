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

public class RequestCreateGroupObsolete extends Request<ResponseCreateGroupObsolete> {

    public static final int HEADER = 0x41;
    public static RequestCreateGroupObsolete fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestCreateGroupObsolete(), data);
    }

    private long rid;
    private String title;
    private List<ApiUserOutPeer> users;

    public RequestCreateGroupObsolete(long rid, @NotNull String title, @NotNull List<ApiUserOutPeer> users) {
        this.rid = rid;
        this.title = title;
        this.users = users;
    }

    public RequestCreateGroupObsolete() {

    }

    public long getRid() {
        return this.rid;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public List<ApiUserOutPeer> getUsers() {
        return this.users;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.rid = values.getLong(1);
        this.title = values.getString(2);
        List<ApiUserOutPeer> _users = new ArrayList<ApiUserOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(3); i ++) {
            _users.add(new ApiUserOutPeer());
        }
        this.users = values.getRepeatedObj(3, _users);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.rid);
        if (this.title == null) {
            throw new IOException();
        }
        writer.writeString(2, this.title);
        writer.writeRepeatedObj(3, this.users);
    }

    @Override
    public String toString() {
        String res = "rpc CreateGroupObsolete{";
        res += "rid=" + this.rid;
        res += ", title=" + this.title;
        res += ", users=" + this.users.size();
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
