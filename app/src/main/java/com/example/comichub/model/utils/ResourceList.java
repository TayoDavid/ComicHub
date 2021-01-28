package com.example.comichub.model.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceList<T> {

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
}
