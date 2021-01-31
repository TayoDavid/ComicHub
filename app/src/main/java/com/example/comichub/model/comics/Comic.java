package com.example.comichub.model.comics;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.comichub.model.utils.RoleSummary;
import com.example.comichub.model.utils.Summary;
import com.example.comichub.model.utils.ImageThumbnail;
import com.example.comichub.model.utils.StorySummary;
import com.example.comichub.model.utils.Url;
import com.example.comichub.model.utils.ResourceList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comic implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("digitalId")
    @Expose
    private int digitalId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("issueNumber")
    @Expose
    private double issueNumber;
    @SerializedName("variantDescription")
    @Expose
    private String variantDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("diamondCode")
    @Expose
    private String diamondCode;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("issn")
    @Expose
    private String issn;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("pageCount")
    @Expose
    private int pageCount;
    @SerializedName("textObjects")
    @Expose
    private List<TextObject> textObjects;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls;
    @SerializedName("series")
    @Expose
    private Summary series;
    @SerializedName("variants")
    @Expose
    private List<Summary> variants;
    @SerializedName("collections")
    @Expose
    private List<Summary> collections;
    @SerializedName("collectedIssues")
    @Expose
    private List<Summary> collectedIssues;
    @SerializedName("dates")
    @Expose
    private List<ComicDate> dates;
    @SerializedName("prices")
    @Expose
    private List<ComicPrice> prices;
    @SerializedName("thumbnail")
    @Expose
    private ImageThumbnail thumbnail;
    @SerializedName("images")
    @Expose
    private List<ImageThumbnail> images;
    @SerializedName("creators")
    @Expose
    private ResourceList<RoleSummary> creators;
    @SerializedName("characters")
    @Expose
    private ResourceList<RoleSummary> characters;
    @SerializedName("stories")
    @Expose
    private ResourceList<StorySummary> stories;
    @SerializedName("events")
    @Expose
    private ResourceList<Summary> events;

    protected Comic(Parcel in) {
        id = in.readInt();
        digitalId = in.readInt();
        title = in.readString();
        issueNumber = in.readDouble();
        variantDescription = in.readString();
        description = in.readString();
        modified = in.readString();
        isbn = in.readString();
        upc = in.readString();
        diamondCode = in.readString();
        ean = in.readString();
        issn = in.readString();
        format = in.readString();
        pageCount = in.readInt();
        resourceURI = in.readString();
        series = in.readParcelable(Summary.class.getClassLoader());
        variants = in.createTypedArrayList(Summary.CREATOR);
        collections = in.createTypedArrayList(Summary.CREATOR);
        collectedIssues = in.createTypedArrayList(Summary.CREATOR);
        thumbnail = in.readParcelable(ImageThumbnail.class.getClassLoader());
        images = in.createTypedArrayList(ImageThumbnail.CREATOR);
        creators = in.readParcelable(ResourceList.class.getClassLoader());
        characters = in.readParcelable(ResourceList.class.getClassLoader());
        stories = in.readParcelable(ResourceList.class.getClassLoader());
        events = in.readParcelable(ResourceList.class.getClassLoader());
    }

    public static final Creator<Comic> CREATOR = new Creator<Comic>() {
        @Override
        public Comic createFromParcel(Parcel in) {
            return new Comic(in);
        }

        @Override
        public Comic[] newArray(int size) {
            return new Comic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(digitalId);
        dest.writeString(title);
        dest.writeDouble(issueNumber);
        dest.writeString(variantDescription);
        dest.writeString(description);
        dest.writeString(modified);
        dest.writeString(isbn);
        dest.writeString(upc);
        dest.writeString(diamondCode);
        dest.writeString(ean);
        dest.writeString(issn);
        dest.writeString(format);
        dest.writeInt(pageCount);
        dest.writeString(resourceURI);
        dest.writeParcelable(series, flags);
        dest.writeTypedList(variants);
        dest.writeTypedList(collections);
        dest.writeTypedList(collectedIssues);
        dest.writeParcelable(thumbnail, flags);
        dest.writeTypedList(images);
        dest.writeParcelable(creators, flags);
        dest.writeParcelable(characters, flags);
        dest.writeParcelable(stories, flags);
        dest.writeParcelable(events, flags);
    }
}
