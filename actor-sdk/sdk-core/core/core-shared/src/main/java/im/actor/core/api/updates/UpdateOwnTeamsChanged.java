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

public class UpdateOwnTeamsChanged extends Update {

    public static final int HEADER = 0xa5;
    public static UpdateOwnTeamsChanged fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateOwnTeamsChanged(), data);
    }

    private List<ApiTeam> ownTeams;

    public UpdateOwnTeamsChanged(@NotNull List<ApiTeam> ownTeams) {
        this.ownTeams = ownTeams;
    }

    public UpdateOwnTeamsChanged() {

    }

    @NotNull
    public List<ApiTeam> getOwnTeams() {
        return this.ownTeams;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiTeam> _ownTeams = new ArrayList<ApiTeam>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _ownTeams.add(new ApiTeam());
        }
        this.ownTeams = values.getRepeatedObj(1, _ownTeams);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.ownTeams);
    }

    @Override
    public String toString() {
        String res = "update OwnTeamsChanged{";
        res += "ownTeams=" + this.ownTeams;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
