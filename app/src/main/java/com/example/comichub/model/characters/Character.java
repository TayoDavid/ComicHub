package com.example.comichub.model.characters;

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
public class Character {

    @SerializedName("id")
    @Expose
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public ImageThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ResourceList<Summary> getComics() {
        return comics;
    }

    public void setComics(ResourceList<Summary> comics) {
        this.comics = comics;
    }

    public ResourceList<StorySummary> getStories() {
        return stories;
    }

    public void setStories(ResourceList<StorySummary> stories) {
        this.stories = stories;
    }

    public ResourceList<Summary> getEvents() {
        return events;
    }

    public void setEvents(ResourceList<Summary> events) {
        this.events = events;
    }

    public ResourceList<Summary> getSeries() {
        return series;
    }

    public void setSeries(ResourceList<Summary> series) {
        this.series = series;
    }

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

}
