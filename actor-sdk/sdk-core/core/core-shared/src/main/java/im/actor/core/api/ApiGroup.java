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

public class ApiGroup extends BserObject {

    private int id;
    private long accessHash;
    private String title;
    private ApiAvatar avatar;
    private Integer membersCount;
    private Boolean isHidden;
    private ApiMapValue ext;
    private boolean isMember;
    private Boolean isAdmin;
    private int creatorUid;
    private List<ApiMember> members;
    private long createDate;
    private String theme;
    private String about;
    private boolean isShare;

    public ApiGroup(int id, long accessHash, @NotNull String title, @Nullable ApiAvatar avatar, @Nullable Integer membersCount, @Nullable Boolean isHidden, @Nullable ApiMapValue ext, boolean isMember, @Nullable Boolean isAdmin, int creatorUid, @NotNull List<ApiMember> members, long createDate, @Nullable String theme, @Nullable String about, boolean isShare) {
        this.id = id;
        this.accessHash = accessHash;
        this.title = title;
        this.avatar = avatar;
        this.membersCount = membersCount;
        this.isHidden = isHidden;
        this.ext = ext;
        this.isMember = isMember;
        this.isAdmin = isAdmin;
        this.creatorUid = creatorUid;
        this.members = members;
        this.createDate = createDate;
        this.theme = theme;
        this.about = about;
        this.isShare = isShare;
    }

    public ApiGroup() {

    }

    public int getId() {
        return this.id;
    }

    public long getAccessHash() {
        return this.accessHash;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Nullable
    public ApiAvatar getAvatar() {
        return this.avatar;
    }

    @Nullable
    public Integer getMembersCount() {
        return this.membersCount;
    }

    @Nullable
    public Boolean isHidden() {
        return this.isHidden;
    }

    @Nullable
    public ApiMapValue getExt() {
        return this.ext;
    }

    public boolean isMember() {
        return this.isMember;
    }

    @Nullable
    public Boolean isAdmin() {
        return this.isAdmin;
    }

    public int getCreatorUid() {
        return this.creatorUid;
    }

    @NotNull
    public List<ApiMember> getMembers() {
        return this.members;
    }

    public long getCreateDate() {
        return this.createDate;
    }

    @Nullable
    public String getTheme() {
        return this.theme;
    }

    @Nullable
    public String getAbout() {
        return this.about;
    }
    
    public boolean isShare() {
        return this.isShare;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getInt(1);
        this.accessHash = values.getLong(2);
        this.title = values.getString(3);
        this.avatar = values.optObj(4, new ApiAvatar());
        this.membersCount = values.optInt(24);
        this.isHidden = values.optBool(20);
        this.ext = values.optObj(22, new ApiMapValue());
        this.isMember = values.getBool(6);
        this.isAdmin = values.optBool(16);
        this.creatorUid = values.getInt(8);
        List<ApiMember> _members = new ArrayList<ApiMember>();
        for (int i = 0; i < values.getRepeatedCount(9); i ++) {
            _members.add(new ApiMember());
        }
        this.members = values.getRepeatedObj(9, _members);
        this.createDate = values.getLong(10);
        this.theme = values.optString(17);
        this.about = values.optString(18);
        this.isShare = values.optBool(27);
        if (values.hasRemaining()) {
            setUnmappedObjects(values.buildRemaining());
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.id);
        writer.writeLong(2, this.accessHash);
        if (this.title == null) {
            throw new IOException();
        }
        writer.writeString(3, this.title);
        if (this.avatar != null) {
            writer.writeObject(4, this.avatar);
        }
        if (this.membersCount != null) {
            writer.writeInt(24, this.membersCount);
        }
        if (this.isHidden != null) {
            writer.writeBool(20, this.isHidden);
        }
        if (this.ext != null) {
            writer.writeObject(22, this.ext);
        }
        writer.writeBool(6, this.isMember);
        if (this.isAdmin != null) {
            writer.writeBool(16, this.isAdmin);
        }
        writer.writeInt(8, this.creatorUid);
        writer.writeRepeatedObj(9, this.members);
        writer.writeLong(10, this.createDate);
        if (this.theme != null) {
            writer.writeString(17, this.theme);
        }
        if (this.about != null) {
            writer.writeString(18, this.about);
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
        String res = "struct Group{";
        res += "id=" + this.id;
        res += ", avatar=" + (this.avatar != null ? "set":"empty");
        res += ", membersCount=" + this.membersCount;
        res += ", isHidden=" + this.isHidden;
        res += ", ext=" + this.ext;
        res += ", isMember=" + this.isMember;
        res += ", isAdmin=" + this.isAdmin;
        res += ", members=" + this.members.size();
        res += ", createDate=" + this.createDate;
        res += ", isShare=" + this.isShare;
        res += "}";
        return res;
    }

}
