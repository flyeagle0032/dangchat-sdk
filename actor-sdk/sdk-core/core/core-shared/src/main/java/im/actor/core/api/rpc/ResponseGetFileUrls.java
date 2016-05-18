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

public class ResponseGetFileUrls extends Response {

    public static final int HEADER = 0xa0e;
    public static ResponseGetFileUrls fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseGetFileUrls(), data);
    }

    private List<ApiFileUrlDescription> fileUrls;

    public ResponseGetFileUrls(@NotNull List<ApiFileUrlDescription> fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ResponseGetFileUrls() {

    }

    @NotNull
    public List<ApiFileUrlDescription> getFileUrls() {
        return this.fileUrls;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiFileUrlDescription> _fileUrls = new ArrayList<ApiFileUrlDescription>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _fileUrls.add(new ApiFileUrlDescription());
        }
        this.fileUrls = values.getRepeatedObj(1, _fileUrls);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.fileUrls);
    }

    @Override
    public String toString() {
        String res = "tuple GetFileUrls{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
