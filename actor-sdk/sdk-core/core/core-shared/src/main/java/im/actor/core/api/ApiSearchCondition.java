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

public abstract class ApiSearchCondition extends BserObject {
    public static ApiSearchCondition fromBytes(byte[] src) throws IOException {
        BserValues values = new BserValues(BserParser.deserialize(new DataInput(src, 0, src.length)));
        int key = values.getInt(1);
        byte[] content = values.getBytes(2);
        switch(key) { 
            case 1: return Bser.parse(new ApiSearchPeerTypeCondition(), content);
            case 2: return Bser.parse(new ApiSearchPieceText(), content);
            case 3: return Bser.parse(new ApiSearchAndCondition(), content);
            case 4: return Bser.parse(new ApiSearchOrCondition(), content);
            case 5: return Bser.parse(new ApiSearchPeerCondition(), content);
            case 6: return Bser.parse(new ApiSearchPeerContentType(), content);
            case 7: return Bser.parse(new ApiSearchSenderIdConfition(), content);
            default: return new ApiSearchConditionUnsupported(key, content);
        }
    }
    public abstract int getHeader();

    public byte[] buildContainer() throws IOException {
        DataOutput res = new DataOutput();
        BserWriter writer = new BserWriter(res);
        writer.writeInt(1, getHeader());
        writer.writeBytes(2, toByteArray());
        return res.toByteArray();
    }

}
