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

public class ApiTextMessage extends ApiMessage {

    private String text;
    private List<Integer> mentions;
    private ApiTextMessageEx ext;

    public ApiTextMessage(@NotNull String text, @NotNull List<Integer> mentions, @Nullable ApiTextMessageEx ext) {
        this.text = text;
        this.mentions = mentions;
        this.ext = ext;
    }

    public ApiTextMessage() {

    }

    public int getHeader() {
        return 1;
    }

    @NotNull
    public String getText() {
        return this.text;
    }

    @NotNull
    public List<Integer> getMentions() {
        return this.mentions;
    }

    @Nullable
    public ApiTextMessageEx getExt() {
        return this.ext;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.text = values.getString(1);
        this.mentions = values.getRepeatedInt(2);
        if (values.optBytes(3) != null) {
            this.ext = ApiTextMessageEx.fromBytes(values.getBytes(3));
        }
        if (values.hasRemaining()) {
            setUnmappedObjects(values.buildRemaining());
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.text == null) {
            throw new IOException();
        }
        writer.writeString(1, this.text);
        writer.writeRepeatedInt(2, this.mentions);
        if (this.ext != null) {
            writer.writeBytes(3, this.ext.buildContainer());
        }
        if (this.getUnmappedObjects() != null) {
            SparseArray<Object> unmapped = this.getUnmappedObjects();
            for (int i = 0; i < unmapped.size(); i++) {
                int key = unmapped.keyAt(i);
                writer.writeUnmapped(key, unmapped.get(key));
            }
        }
    }

    @Override
    public String toString() {
        String res = "struct TextMessage{";
        res += "mentions=" + this.mentions;
        res += ", ext=" + this.ext;
        res += "}";
        return res;
    }

}
