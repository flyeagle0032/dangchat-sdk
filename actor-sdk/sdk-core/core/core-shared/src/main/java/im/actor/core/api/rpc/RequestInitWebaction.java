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

public class RequestInitWebaction extends Request<ResponseInitWebaction> {

    public static final int HEADER = 0x74;
    public static RequestInitWebaction fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestInitWebaction(), data);
    }

    private String actionName;
    private ApiMapValue params;

    public RequestInitWebaction(@NotNull String actionName, @NotNull ApiMapValue params) {
        this.actionName = actionName;
        this.params = params;
    }

    public RequestInitWebaction() {

    }

    @NotNull
    public String getActionName() {
        return this.actionName;
    }

    @NotNull
    public ApiMapValue getParams() {
        return this.params;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.actionName = values.getString(1);
        this.params = values.getObj(2, new ApiMapValue());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.actionName == null) {
            throw new IOException();
        }
        writer.writeString(1, this.actionName);
        if (this.params == null) {
            throw new IOException();
        }
        writer.writeObject(2, this.params);
    }

    @Override
    public String toString() {
        String res = "rpc InitWebaction{";
        res += "actionName=" + this.actionName;
        res += ", params=" + this.params;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
