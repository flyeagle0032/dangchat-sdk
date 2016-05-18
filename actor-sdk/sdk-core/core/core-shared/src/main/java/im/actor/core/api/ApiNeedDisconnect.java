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

public class ApiNeedDisconnect extends ApiWebRTCSignaling {

    private long device;

    public ApiNeedDisconnect(long device) {
        this.device = device;
    }

    public ApiNeedDisconnect() {

    }

    public int getHeader() {
        return 20;
    }

    public long getDevice() {
        return this.device;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.device = values.getLong(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.device);
    }

    @Override
    public String toString() {
        String res = "struct NeedDisconnect{";
        res += "}";
        return res;
    }

}
