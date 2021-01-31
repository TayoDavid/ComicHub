package com.example.comichub.model.characters;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.comichub.model.utils.ImageThumbnail;
import com.example.comichub.model.utils.ResourceList;
import com.example.comichub.model.utils.StorySummary;
import com.example.comichub.model.utils.Summary;
import com.example.comichub.model.utils.Url;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Character implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls = null;
    @SerializedName("thumbnail")
    @Expose
    private ImageThumbnail thumbnail;
    @SerializedName("comics")
    @Expose
    private ResourceList<Summary> comics;
    @SerializedName("stories")
    @Expose
    private ResourceList<StorySummary> stories;
    @SerializedName("events")
    @Expose
    private ResourceList<Summary> events;
    @SerializedName("series")
    @Expose
    private ResourceList<Summary>series;

    protected Character(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        modified = in.readString();
        resourceURI = in.readString();
        thumbnail = in.readParcelable(ImageThumbnail.class.getClassLoader());
        comics = in.readParcelable(ResourceList.class.getClassLoader());
        stories = in.readParcelable(ResourceList.class.getClassLoader());
        events = in.readParcelable(ResourceList.class.getClassLoader());
        series = in.readParcelable(ResourceList.class.getClassLoader());
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(modified);
        dest.writeString(resourceURI);
        dest.writeParcelable(thumbnail, flags);
        dest.writeParcelable(comics, flags);
        dest.writeParcelable(stories, flags);
        dest.writeParcelable(events, flags);
        dest.writeParcelable(series, flags);
    }
}
