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

public class ApiAnswer extends ApiWebRTCSignaling {

    private long sessionId;
    private String sdp;

    public ApiAnswer(long sessionId, @NotNull String sdp) {
        this.sessionId = sessionId;
        this.sdp = sdp;
    }

    public ApiAnswer() {

    }

    public int getHeader() {
        return 5;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public String getSdp() {
        return this.sdp;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.sessionId = values.getLong(1);
        this.sdp = values.getString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.sessionId);
        if (this.sdp == null) {
            throw new IOException();
        }
        writer.writeString(2, this.sdp);
    }

    @Override
    public String toString() {
        String res = "struct Answer{";
        res += "sessionId=" + this.sessionId;
        res += ", sdp=" + this.sdp;
        res += "}";
        return res;
    }

}
