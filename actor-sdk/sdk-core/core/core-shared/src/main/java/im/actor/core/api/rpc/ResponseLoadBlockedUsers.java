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

public class ResponseLoadBlockedUsers extends Response {

    public static final int HEADER = 0xa4f;
    public static ResponseLoadBlockedUsers fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseLoadBlockedUsers(), data);
    }

    private List<ApiUserOutPeer> userPeers;

    public ResponseLoadBlockedUsers(@NotNull List<ApiUserOutPeer> userPeers) {
        this.userPeers = userPeers;
    }

    public ResponseLoadBlockedUsers() {

    }

    @NotNull
    public List<ApiUserOutPeer> getUserPeers() {
        return this.userPeers;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiUserOutPeer> _userPeers = new ArrayList<ApiUserOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _userPeers.add(new ApiUserOutPeer());
        }
        this.userPeers = values.getRepeatedObj(1, _userPeers);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.userPeers);
    }

    @Override
    public String toString() {
        String res = "tuple LoadBlockedUsers{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
