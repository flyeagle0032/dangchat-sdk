package im.actor.core.api.updates;
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

public class UpdateUserAboutChanged extends Update {

    public static final int HEADER = 0xd2;
    public static UpdateUserAboutChanged fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateUserAboutChanged(), data);
    }

    private int uid;
    private String about;

    public UpdateUserAboutChanged(int uid, @Nullable String about) {
        this.uid = uid;
        this.about = about;
    }

    public UpdateUserAboutChanged() {

    }

    public int getUid() {
        return this.uid;
    }

    @Nullable
    public String getAbout() {
        return this.about;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uid = values.getInt(1);
        this.about = values.optString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.uid);
        if (this.about != null) {
            writer.writeString(2, this.about);
        }
    }

    @Override
    public String toString() {
        String res = "update UserAboutChanged{";
        res += "uid=" + this.uid;
        res += ", about=" + this.about;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
