package com.example.comichub.model.events;

import java.util.List;

import com.example.comichub.model.creators.Creator;
import com.example.comichub.model.utils.ImageThumbnail;
import com.example.comichub.model.utils.ResourceList;
import com.example.comichub.model.utils.StorySummary;
import com.example.comichub.model.utils.Summary;
import com.example.comichub.model.utils.Url;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Event {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls = null;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    private ImageThumbnail thumbnail;
    @SerializedName("creators")
    @Expose
    private ResourceList<Creator> creators;
    @SerializedName("characters")
    @Expose
    private ResourceList<Character> characters;
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
    private ResourceList<Summary> series;
    @SerializedName("next")
    @Expose
    private Summary next;
    @SerializedName("previous")
    @Expose
    private Summary previous;
}