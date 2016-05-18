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

public class ApiWallpapper extends BserObject {

    private int id;
    private int w;
    private int h;
    private int fileSize;
    private ApiFileLocation file;
    private ApiFastThumb thumb;

    public ApiWallpapper(int id, int w, int h, int fileSize, @NotNull ApiFileLocation file, @NotNull ApiFastThumb thumb) {
        this.id = id;
        this.w = w;
        this.h = h;
        this.fileSize = fileSize;
        this.file = file;
        this.thumb = thumb;
    }

    public ApiWallpapper() {

    }

    public int getId() {
        return this.id;
    }

    public int getW() {
        return this.w;
    }

    public int getH() {
        return this.h;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    @NotNull
    public ApiFileLocation getFile() {
        return this.file;
    }

    @NotNull
    public ApiFastThumb getThumb() {
        return this.thumb;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getInt(7);
        this.w = values.getInt(1);
        this.h = values.getInt(2);
        this.fileSize = values.getInt(3);
        this.file = values.getObj(5, new ApiFileLocation());
        this.thumb = values.getObj(6, new ApiFastThumb());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(7, this.id);
        writer.writeInt(1, this.w);
        writer.writeInt(2, this.h);
        writer.writeInt(3, this.fileSize);
        if (this.file == null) {
            throw new IOException();
        }
        writer.writeObject(5, this.file);
        if (this.thumb == null) {
            throw new IOException();
        }
        writer.writeObject(6, this.thumb);
    }

    @Override
    public String toString() {
        String res = "struct Wallpapper{";
        res += "id=" + this.id;
        res += ", w=" + this.w;
        res += ", h=" + this.h;
        res += ", fileSize=" + this.fileSize;
        res += ", file=" + this.file;
        res += ", thumb=" + this.thumb;
        res += "}";
        return res;
    }

}
