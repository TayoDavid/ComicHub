package com.example.comichub.model.comics;

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
public class Comic {

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
    private LocalDate modified;
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
    private List<Summary> series;
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

}
