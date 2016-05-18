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

public class ApiPeer extends BserObject {

    private ApiPeerType type;
    private int id;

    public ApiPeer(@NotNull ApiPeerType type, int id) {
        this.type = type;
        this.id = id;
    }

    public ApiPeer() {

    }

    @NotNull
    public ApiPeerType getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.type = ApiPeerType.parse(values.getInt(1));
        this.id = values.getInt(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.type == null) {
            throw new IOException();
        }
        writer.writeInt(1, this.type.getValue());
        writer.writeInt(2, this.id);
    }

    @Override
    public String toString() {
        String res = "struct Peer{";
        res += "type=" + this.type;
        res += ", id=" + this.id;
        res += "}";
        return res;
    }

}
