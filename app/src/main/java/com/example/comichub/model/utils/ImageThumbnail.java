package com.example.comichub.model.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageThumbnail implements Parcelable {

    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("extension")
    @Expose
    private String extension;

    protected ImageThumbnail(Parcel in) {
        path = in.readString();
        extension = in.readString();
    }

    public static final Creator<ImageThumbnail> CREATOR = new Creator<ImageThumbnail>() {
        @Override
        public ImageThumbnail createFromParcel(Parcel in) {
            return new ImageThumbnail(in);
        }

        @Override
        public ImageThumbnail[] newArray(int size) {
            return new ImageThumbnail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(extension);
    }
}
