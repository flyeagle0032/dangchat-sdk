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

public class ApiEmailToImport extends BserObject {

    private String email;
    private String name;

    public ApiEmailToImport(@NotNull String email, @Nullable String name) {
        this.email = email;
        this.name = name;
    }

    public ApiEmailToImport() {

    }

    @NotNull
    public String getEmail() {
        return this.email;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.email = values.getString(1);
        this.name = values.optString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.email == null) {
            throw new IOException();
        }
        writer.writeString(1, this.email);
        if (this.name != null) {
            writer.writeString(2, this.name);
        }
    }

    @Override
    public String toString() {
        String res = "struct EmailToImport{";
        res += "email=" + this.email;
        res += ", name=" + this.name;
        res += "}";
        return res;
    }

}
