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

public class ApiAppCounters extends BserObject {

    private Integer globalCounter;

    public ApiAppCounters(@Nullable Integer globalCounter) {
        this.globalCounter = globalCounter;
    }

    public ApiAppCounters() {

    }

    @Nullable
    public Integer getGlobalCounter() {
        return this.globalCounter;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.globalCounter = values.optInt(1);
        if (values.hasRemaining()) {
            setUnmappedObjects(values.buildRemaining());
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.globalCounter != null) {
            writer.writeInt(1, this.globalCounter);
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
        String res = "struct AppCounters{";
        res += "globalCounter=" + this.globalCounter;
        res += "}";
        return res;
    }

}
