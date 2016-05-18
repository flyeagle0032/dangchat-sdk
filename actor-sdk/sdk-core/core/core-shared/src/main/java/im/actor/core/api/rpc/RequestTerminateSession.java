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

public class RequestTerminateSession extends Request<ResponseVoid> {

    public static final int HEADER = 0x52;
    public static RequestTerminateSession fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestTerminateSession(), data);
    }

    private int id;

    public RequestTerminateSession(int id) {
        this.id = id;
    }

    public RequestTerminateSession() {

    }

    public int getId() {
        return this.id;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getInt(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.id);
    }

    @Override
    public String toString() {
        String res = "rpc TerminateSession{";
        res += "id=" + this.id;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
