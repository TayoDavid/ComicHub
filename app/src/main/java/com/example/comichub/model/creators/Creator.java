package com.example.comichub.model.creators;

import com.example.comichub.model.utils.ResourceList;
import com.example.comichub.model.utils.ImageThumbnail;
import com.example.comichub.model.utils.StorySummary;
import com.example.comichub.model.utils.Summary;
import com.example.comichub.model.utils.Url;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Creator {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("modified")
    @Expose
    private LocalDate modified;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls;
    @SerializedName("thumbnail")
    @Expose
    private ImageThumbnail thumbnail;
    @SerializedName("series")
    @Expose
    private ResourceList<Summary> series;
    @SerializedName("stories")
    @Expose
    private ResourceList<StorySummary> stories;
    @SerializedName("comics")
    @Expose
    private ResourceList<Summary> comics;
    @SerializedName("events")
    @Expose
    private ResourceList<Summary> events;

}
