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

public class RequestSubscribeFromOnline extends Request<ResponseVoid> {

    public static final int HEADER = 0x21;
    public static RequestSubscribeFromOnline fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestSubscribeFromOnline(), data);
    }

    private List<ApiUserOutPeer> users;

    public RequestSubscribeFromOnline(@NotNull List<ApiUserOutPeer> users) {
        this.users = users;
    }

    public RequestSubscribeFromOnline() {

    }

    @NotNull
    public List<ApiUserOutPeer> getUsers() {
        return this.users;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiUserOutPeer> _users = new ArrayList<ApiUserOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _users.add(new ApiUserOutPeer());
        }
        this.users = values.getRepeatedObj(1, _users);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.users);
    }

    @Override
    public String toString() {
        String res = "rpc SubscribeFromOnline{";
        res += "users=" + this.users.size();
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
