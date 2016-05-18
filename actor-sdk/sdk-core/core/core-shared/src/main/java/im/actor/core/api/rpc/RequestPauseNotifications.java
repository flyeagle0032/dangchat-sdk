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

public class RequestPauseNotifications extends Request<ResponseVoid> {

    public static final int HEADER = 0xa51;
    public static RequestPauseNotifications fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestPauseNotifications(), data);
    }

    private int timeout;

    public RequestPauseNotifications(int timeout) {
        this.timeout = timeout;
    }

    public RequestPauseNotifications() {

    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.timeout = values.getInt(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.timeout);
    }

    @Override
    public String toString() {
        String res = "rpc PauseNotifications{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
