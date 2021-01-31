package com.example.comichub.model.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceList<T> implements Parcelable {

    @SerializedName("available")
    @Expose
    private int available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<T> items = null;
    @SerializedName("returned")
    @Expose
    private int returned;

    protected ResourceList(Parcel in) {
        available = in.readInt();
        collectionURI = in.readString();
        returned = in.readInt();
    }

    public static final Creator<ResourceList> CREATOR = new Creator<ResourceList>() {
        @Override
        public ResourceList createFromParcel(Parcel in) {
            return new ResourceList(in);
        }

        @Override
        public ResourceList[] newArray(int size) {
            return new ResourceList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(available);
        dest.writeString(collectionURI);
        dest.writeInt(returned);
    }
}
