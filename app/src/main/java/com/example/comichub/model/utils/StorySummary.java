package com.example.comichub.model.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StorySummary implements Parcelable {

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;

    protected StorySummary(Parcel in) {
        resourceURI = in.readString();
        name = in.readString();
        type = in.readString();
    }

    public static final Creator<StorySummary> CREATOR = new Creator<StorySummary>() {
        @Override
        public StorySummary createFromParcel(Parcel in) {
            return new StorySummary(in);
        }

        @Override
        public StorySummary[] newArray(int size) {
            return new StorySummary[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resourceURI);
        dest.writeString(name);
        dest.writeString(type);
    }
}