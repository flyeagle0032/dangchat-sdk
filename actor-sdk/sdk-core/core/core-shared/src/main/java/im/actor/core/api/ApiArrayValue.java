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

public class ApiArrayValue extends ApiRawValue {

    private List<ApiRawValue> array;

    public ApiArrayValue(@NotNull List<ApiRawValue> array) {
        this.array = array;
    }

    public ApiArrayValue() {

    }

    public int getHeader() {
        return 5;
    }

    @NotNull
    public List<ApiRawValue> getArray() {
        return this.array;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.array = new ArrayList<ApiRawValue>();
        for (byte[] b : values.getRepeatedBytes(1)) {
            array.add(ApiRawValue.fromBytes(b));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        for (ApiRawValue i : this.array) {
            writer.writeBytes(1, i.buildContainer());
        }
    }

    @Override
    public String toString() {
        String res = "struct ArrayValue{";
        res += "}";
        return res;
    }

}
