package im.actor.core.api;
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

public class ApiCloseSession extends ApiWebRTCSignaling {

    private long device;
    private long sessionId;

    public ApiCloseSession(long device, long sessionId) {
        this.device = device;
        this.sessionId = sessionId;
    }

    public ApiCloseSession() {

    }

    public int getHeader() {
        return 6;
    }

    public long getDevice() {
        return this.device;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.device = values.getLong(1);
        this.sessionId = values.getLong(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.device);
        writer.writeLong(2, this.sessionId);
    }

    @Override
    public String toString() {
        String res = "struct CloseSession{";
        res += "sessionId=" + this.sessionId;
        res += "}";
        return res;
    }

}
