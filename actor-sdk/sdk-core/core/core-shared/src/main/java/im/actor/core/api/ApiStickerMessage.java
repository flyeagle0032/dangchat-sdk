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

public class ApiStickerMessage extends ApiMessage {

    private Integer stickerId;
    private byte[] fastPreview;
    private ApiImageLocation image512;
    private ApiImageLocation image256;
    private Integer stickerCollectionId;
    private Long stickerCollectionAccessHash;

    public ApiStickerMessage(@Nullable Integer stickerId, @Nullable byte[] fastPreview, @Nullable ApiImageLocation image512, @Nullable ApiImageLocation image256, @Nullable Integer stickerCollectionId, @Nullable Long stickerCollectionAccessHash) {
        this.stickerId = stickerId;
        this.fastPreview = fastPreview;
        this.image512 = image512;
        this.image256 = image256;
        this.stickerCollectionId = stickerCollectionId;
        this.stickerCollectionAccessHash = stickerCollectionAccessHash;
    }

    public ApiStickerMessage() {

    }

    public int getHeader() {
        return 6;
    }

    @Nullable
    public Integer getStickerId() {
        return this.stickerId;
    }

    @Nullable
    public byte[] getFastPreview() {
        return this.fastPreview;
    }

    @Nullable
    public ApiImageLocation getImage512() {
        return this.image512;
    }

    @Nullable
    public ApiImageLocation getImage256() {
        return this.image256;
    }

    @Nullable
    public Integer getStickerCollectionId() {
        return this.stickerCollectionId;
    }

    @Nullable
    public Long getStickerCollectionAccessHash() {
        return this.stickerCollectionAccessHash;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.stickerId = values.optInt(1);
        this.fastPreview = values.optBytes(2);
        this.image512 = values.optObj(3, new ApiImageLocation());
        this.image256 = values.optObj(4, new ApiImageLocation());
        this.stickerCollectionId = values.optInt(5);
        this.stickerCollectionAccessHash = values.optLong(6);
        if (values.hasRemaining()) {
            setUnmappedObjects(values.buildRemaining());
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.stickerId != null) {
            writer.writeInt(1, this.stickerId);
        }
        if (this.fastPreview != null) {
            writer.writeBytes(2, this.fastPreview);
        }
        if (this.image512 != null) {
            writer.writeObject(3, this.image512);
        }
        if (this.image256 != null) {
            writer.writeObject(4, this.image256);
        }
        if (this.stickerCollectionId != null) {
            writer.writeInt(5, this.stickerCollectionId);
        }
        if (this.stickerCollectionAccessHash != null) {
            writer.writeLong(6, this.stickerCollectionAccessHash);
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
        String res = "struct StickerMessage{";
        res += "stickerId=" + this.stickerId;
        res += ", fastPreview=" + this.fastPreview;
        res += ", image512=" + this.image512;
        res += ", image256=" + this.image256;
        res += ", stickerCollectionId=" + this.stickerCollectionId;
        res += ", stickerCollectionAccessHash=" + this.stickerCollectionAccessHash;
        res += "}";
        return res;
    }

}
